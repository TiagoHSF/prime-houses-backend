package com.br.plataformacorretor10.controller;

import com.br.plataformacorretor10.exception.ServiceException;
import com.br.plataformacorretor10.model.dto.UsuarioDTO;
import com.br.plataformacorretor10.model.jpa.Usuario;
import com.br.plataformacorretor10.service.UsuarioService;
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
    public @ResponseBody ResponseEntity<?> criar(@RequestBody UsuarioDTO usuarioDTO) throws ServiceException {
        try {
            final Usuario usuario = this.usuarioService.criar(usuarioDTO);
            return ResponseEntity.ok(usuario);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("validar-codigo/{codigo}")
    public void validarCodigo(@PathParam("codigo") Integer codigo) throws ServiceException {
        try {

        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
    }

}