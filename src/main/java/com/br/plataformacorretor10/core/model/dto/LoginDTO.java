package com.br.plataformacorretor10.core.model.dto;

/**
 * The Class LoginDTO
 *
 * @author Tiago Ferreira.
 * @since 03/11/2023
 */
public class LoginDTO {

    private String email;

    private String senha;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}