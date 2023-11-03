package com.br.plataformacorretor10.core.auth;

import com.br.plataformacorretor10.core.model.dto.LoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

}