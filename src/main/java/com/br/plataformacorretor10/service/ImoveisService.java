package com.br.plataformacorretor10.service;

import com.br.plataformacorretor10.exception.ServiceException;
import com.br.plataformacorretor10.model.dto.ImovelDTO;
import com.br.plataformacorretor10.model.jpa.DetalhesImovel;
import com.br.plataformacorretor10.model.jpa.Imovel;
import com.br.plataformacorretor10.model.jpa.Corretor;
import com.br.plataformacorretor10.model.jpa.Endereco;
import com.br.plataformacorretor10.repository.CorretorRepository;
import com.br.plataformacorretor10.repository.DetalhesRepository;
import com.br.plataformacorretor10.repository.EnderecoRepository;
import com.br.plataformacorretor10.repository.ImoveisRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

/**
 * Imóveis service
 *
 * @author Tiago
 * @date 1 de nov de 2023
 * */
@Service
public class ImoveisService {

    @Autowired
    private ImoveisRepository imoveisRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private DetalhesRepository detalhesRepository;

    @Autowired
    private CorretorRepository corretorRepository;

    /**
     * Criar imóvel
     */
    @Transactional(rollbackOn = Exception.class)
    public Imovel criar(final ImovelDTO imovelDTO, final Long corretorId) throws ServiceException {
        try {
            Imovel imovelBase = new Imovel(imovelDTO);
            if(Objects.nonNull(imovelDTO.getId())){
                return this.editar(imovelDTO);
            }
            /*ENDEREÇO*/
            Endereco endereco = new Endereco(imovelDTO.endereco);
            endereco = this.enderecoRepository.save(endereco);
            /*ENDEREÇO*/

            /*DETALHES*/
            DetalhesImovel detalhes = new DetalhesImovel(imovelDTO.getDetalhes());
            detalhes = this.detalhesRepository.save(detalhes);
            /*DETALHES*/

            /* CORRETOR */
            Optional<Corretor> corretor = this.corretorRepository.findById(corretorId);
            if(corretor.isPresent()){
                imovelBase.setCorretor(corretor.get());
            } else {
                throw new Exception("Corretor não informado!");
            }
            /* CORRETOR */

            /* EMPRESA */
            if(Objects.nonNull(corretor.get().getEmpresa())){
                imovelBase.setEmpresa(corretor.get().getEmpresa());
            } else {
                throw new Exception("Empresa não informada!");
            }
            /* */

            imovelBase.setEndereco(endereco);
            imovelBase.setDetalhes(detalhes);

            imovelBase = this.imoveisRepository.save(imovelBase);
            return imovelBase;
        } catch (Exception e){
            throw new ServiceException(e.getMessage());
        }
    }

    /**
     * Listar
     */
    public Page<Imovel> listar(Pageable page, Long empresaId) throws ServiceException {
        try {
            Page<Imovel> imoveis = this.imoveisRepository.findImoveis(page, empresaId);
            return imoveis;
        } catch (Exception e){
            throw new ServiceException(e.getMessage());
        }
    }

    /**
     * Excluir
     */
    public void excluir(final Long id) throws ServiceException {
        try {
            this.imoveisRepository.desativarById(id, LocalDateTime.now());
        } catch (Exception e){
            throw new ServiceException(e.getMessage());
        }
    }

    public Imovel editar(final ImovelDTO imovelDTO) throws ServiceException {
        try {
            Imovel imovelBD = this.imoveisRepository.findById(imovelDTO.getId()).orElseThrow(()-> new Exception("Imóvel não encontrado!"));
            imovelBD = new Imovel(imovelDTO);
            imovelBD.setId(imovelDTO.getId());
            imovelBD = this.imoveisRepository.save(imovelBD);
            return imovelBD;
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
