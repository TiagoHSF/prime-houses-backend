package com.br.plataformacorretor10.controller;

import com.br.plataformacorretor10.exception.ServiceException;
import com.br.plataformacorretor10.service.AuthService;
import com.br.plataformacorretor10.model.dto.LoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.br.plataformacorretor10.model.jpa.Usuario;

/**
 * The Class AuthController
 *
 * @author Tiago Ferreira.
 * @since 03/11/2023
 */
@Controller()
@RequestMapping("auth/")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("login")
    public @ResponseBody ResponseEntity<?> login(@RequestBody LoginDTO login) throws ServiceException {
        try {
            final Usuario usuario = this.authService.login(login);
            return ResponseEntity.ok(usuario);
        } catch (Exception e){
            throw new ServiceException(e.getMessage());
        }
    }

    @GetMapping("find-usuario")
    @ResponseBody
    private ResponseEntity<?> findUser(@RequestParam("token") final String token) throws ServiceException {
        try {
            final Usuario usuario = this.authService.findUser(token);
            return ResponseEntity.ok(usuario);
        } catch (Exception e){
            throw new ServiceException(e.getMessage());
        }
    }

}