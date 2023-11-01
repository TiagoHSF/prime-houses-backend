package com.br.plataformacorretor10.corretor.imoveis;

import com.br.plataformacorretor10.corretor.imoveis.model.dto.ImovelDTO;
import com.br.plataformacorretor10.corretor.imoveis.model.jpa.Imovel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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
    public Page<Imovel> listar() throws Exception {
        try {
            return null;
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

}
