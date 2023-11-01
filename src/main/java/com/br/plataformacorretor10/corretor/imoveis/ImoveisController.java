package com.br.plataformacorretor10.corretor.imoveis;

import com.br.plataformacorretor10.corretor.imoveis.model.dto.ImovelDTO;
import com.br.plataformacorretor10.corretor.imoveis.model.jpa.Imovel;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

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
    public @ResponseBody ResponseEntity<Imovel> criar(@RequestBody ImovelDTO imovel) throws Exception {
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
    public @ResponseBody ResponseEntity<ImovelDTO> listar(
        @RequestParam(value = "page", required = true, defaultValue = "0") final Integer page,
        @RequestParam(value = "size", required = true, defaultValue = "10") final Integer size,
        @RequestParam(value = "order", required = false) final String query
    ) throws Exception {
        try {
            final var api = this.imoveisService.listar();
            return ResponseEntity.ok(api);
        } catch(Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @DeleteMapping("excluir{id}")
    public void excluir(@PathParam("id") Long id) throws Exception{
        try {
            if(Objects.isNull(id)){
                throw new Exception("Imóvel não informado");
            }
            this.imoveisService.excluir(id);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
