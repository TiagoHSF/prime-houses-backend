package com.br.plataformacorretor10.corretor.imoveis;

import com.br.plataformacorretor10.corretor.imoveis.model.dto.ImovelDTO;
import org.springframework.stereotype.Service;

/**
 * Imóveis service
 *
 * @author Tiago
 * @date 1 de nov de 2023
 * */
@Service
public class ImoveisService {

    public ImovelDTO criar(final ImovelDTO imovel) throws Exception{
        try {
            return imovel;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public ImovelDTO listar() throws Exception {
        try {
            ImovelDTO imovel = new ImovelDTO();
            return imovel;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public ImovelDTO excluir(final Long id) throws Exception {
        try {
            ImovelDTO imovel = new ImovelDTO();
            return imovel;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}
