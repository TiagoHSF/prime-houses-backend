package com.br.plataformacorretor10.controller;

import com.br.plataformacorretor10.exception.ServiceException;
import com.br.plataformacorretor10.model.dto.ImovelDTO;
import com.br.plataformacorretor10.model.jpa.Imovel;
import com.br.plataformacorretor10.model.util.CustomPageable;
import com.br.plataformacorretor10.service.ImoveisService;
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
    public @ResponseBody ResponseEntity<Imovel> criar(@RequestBody ImovelDTO imovel, @RequestParam("corretorId") final Long corretorId, @RequestParam("empresaId") final Long empresaId) throws ServiceException {
        try {
            final var api = this.imoveisService.criar(imovel, corretorId);
            return ResponseEntity.ok(api);
        } catch(Exception e) {
            throw new ServiceException(e.getMessage());
        }
    }

    /**
     * Listar imóveis
     *
     * @author Tiago
     * @date 1 de nov de 2023
     * */
    @GetMapping("listar")
    public @ResponseBody ResponseEntity<?> listar(
        @RequestParam(value = "page", required = true, defaultValue = "0") final Integer page,
        @RequestParam(value = "size", required = true, defaultValue = "10") final Integer size,
        @RequestParam(value = "order", required = false) final String order,
        @RequestParam(value = "empresaId", required = false) final Long empresaId
    ) throws ServiceException {
        try {
            final var api = this.imoveisService.listar(CustomPageable.generatePage(page, size, order), empresaId);
            return ResponseEntity.ok(api);
        } catch(Exception e) {
            throw new ServiceException(e.getMessage());
        }
    }

    /**
     * Excluir imóvel
     *
     * @author Tiago
     * @date 1 de nov de 2023
     * */
    @DeleteMapping("excluir{id}")
    public void excluir(@PathParam("id") Long id) throws ServiceException{
        try {
            if(Objects.isNull(id)){
                throw new Exception("Imóvel não informado");
            }
            this.imoveisService.excluir(id);
        } catch (Exception e){
            throw new ServiceException(e.getMessage());
        }
    }
}
