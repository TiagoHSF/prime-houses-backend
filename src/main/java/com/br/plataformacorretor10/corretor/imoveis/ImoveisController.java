package com.br.plataformacorretor10.corretor.imoveis;

import com.br.plataformacorretor10.corretor.imoveis.model.dto.ImovelDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Imóveis
 *
 * @author Tiago
 * @date 1 de nov de 2023
 * */
@Controller()
@RequestMapping("corretor/imoveis/")
public class ImoveisController {

    @Autowired
    private ImoveisService imoveisService;

    /**
     * Criar imóvel
     *
     * @author Tiago
     * @date 1 de nov de 2023
     * */
    @PostMapping("criar")
    public @ResponseBody ResponseEntity<ImovelDTO> criar(@RequestBody ImovelDTO imovel) throws Exception {
        try {
            final var api = this.imoveisService.criar(imovel);
            return ResponseEntity.ok(api);
        } catch(Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    /**
     * Listar imóveis
     *
     * @author Tiago
     * @date 1 de nov de 2023
     * */
    @GetMapping("listar")
    public @ResponseBody ResponseEntity<ImovelDTO> listar() throws Exception {
        try {
            final var api = this.imoveisService.listar();
            return ResponseEntity.ok(api);
        } catch(Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
