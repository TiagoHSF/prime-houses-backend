package com.br.plataformacorretor10.corretor.imoveis;

import com.br.plataformacorretor10.corretor.imoveis.model.dto.ImovelDTO;
import com.br.plataformacorretor10.corretor.imoveis.model.jpa.Imovel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

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

    /**
     * Criar imóvel
     */
    public Imovel criar(final ImovelDTO imovelDTO) throws Exception{
        try {
            if(Objects.nonNull(imovelDTO.getId())){
                this.editar(imovelDTO);
            }
            Imovel imovelBase = new Imovel(imovelDTO);
            imovelBase = this.imoveisRepository.save(imovelBase);
            return imovelBase;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    /**
     * Listar
     */
    public Page<Imovel> listar(Pageable page) throws Exception {
        try {
            Page<Imovel> imoveis = this.imoveisRepository.findImoveis(page);
            return imoveis;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    /**
     * Excluir
     */
    public void excluir(final Long id) throws Exception {
        try {
            this.imoveisRepository.desativarById(id, LocalDateTime.now());
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public Imovel editar(final ImovelDTO imovelDTO) throws Exception {
        try {
            Imovel imovelBD = this.imoveisRepository.findById(imovelDTO.getId()).orElseThrow(()-> new Exception("Imóvel não encontrado!"));
            imovelBD = new Imovel(imovelDTO);
            imovelBD.setId(imovelDTO.getId());
            imovelBD = this.imoveisRepository.save(imovelBD);
            return imovelBD;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
