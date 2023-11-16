package com.br.plataformacorretor10.controller;

import com.br.plataformacorretor10.service.UsuarioService;
import com.br.plataformacorretor10.model.dto.UsuarioDTO;
import com.br.plataformacorretor10.model.jpa.Usuario;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * The Class UsuarioController
 *
 * @author Tiago Ferreira.
 * @since 03/11/2023
 */
@Controller()
@RequestMapping("usuario/")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("criar")
    public @ResponseBody ResponseEntity<Usuario> criar(@RequestBody UsuarioDTO usuarioDTO) throws Exception {
        try {
            final Usuario usuario = this.usuarioService.criar(usuarioDTO);
            return ResponseEntity.ok(usuario);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @PostMapping("validar-codigo/{codigo}")
    public void validarCodigo(@PathParam("codigo") Integer codigo) throws Exception {
        try {

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}