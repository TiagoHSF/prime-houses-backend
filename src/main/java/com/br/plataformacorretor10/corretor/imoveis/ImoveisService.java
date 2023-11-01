package com.br.plataformacorretor10.corretor.imoveis;

import com.br.plataformacorretor10.corretor.imoveis.model.dto.ImovelDTO;
import com.br.plataformacorretor10.corretor.imoveis.model.jpa.Imovel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Imovel criar(final ImovelDTO imovel) throws Exception{
        try {
            Imovel imovelBase = new Imovel();
            imovelBase.setTitulo("teste");
            imovelBase = this.imoveisRepository.save(imovelBase);
            return imovelBase;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    /**
     * Listar
     */
    public ImovelDTO listar() throws Exception {
        try {
            ImovelDTO imovel = new ImovelDTO();
            return imovel;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    /**
     * Excluir
     */
    public ImovelDTO excluir(final Long id) throws Exception {
        try {
            ImovelDTO imovel = new ImovelDTO();
            return imovel;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}
