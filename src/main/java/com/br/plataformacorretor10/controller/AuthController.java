package com.br.plataformacorretor10.controller;

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
    public @ResponseBody ResponseEntity<String> login(@RequestBody LoginDTO login) throws Exception {
        try {
            final String token = this.authService.login(login);
            return ResponseEntity.ok(token);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @GetMapping("find-usuario")
    @ResponseBody
    private ResponseEntity<Usuario> findUser(@RequestParam("token") final String token) throws Exception {
        try {
            final Usuario usuario = this.authService.findUser(token);
            return ResponseEntity.ok(usuario);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}