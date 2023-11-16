package com.br.plataformacorretor10.controller;

import com.br.plataformacorretor10.service.EmpresaService;
import com.br.plataformacorretor10.model.dto.EmpresaDTO;
import com.br.plataformacorretor10.model.jpa.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * The Class EmpresaController
 *
 * @author Tiago Ferreira.
 * @since 10/11/2023
 */
@Controller()
@RequestMapping("corretor/empresa/")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @PostMapping("criar")
    public @ResponseBody ResponseEntity<Empresa> criar(@RequestBody EmpresaDTO empresaDTO,
        @RequestParam("corretorId") final Long corretorId) throws Exception {
        try {
            final var api = this.empresaService.criar(empresaDTO, corretorId);
            return ResponseEntity.ok(api);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    ///*/*/*/*FUTURAMENTE SERÁ IMPLEMENTO A ADIÇÃO DE MAIS CORRETORES PARA
    // A EMPRESA, NO MOMENTO SOMENTE O CORRETOR QUE CRIA QUE RECEBE O VINCULO COM A EMPRESA



}