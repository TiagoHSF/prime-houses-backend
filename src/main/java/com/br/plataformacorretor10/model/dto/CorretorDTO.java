package com.br.plataformacorretor10.model.dto;

/**
 * The Class CorretorDTO
 *
 * @author Tiago Ferreira.
 * @since 07/11/2023
 */
public class CorretorDTO extends GenericDTO {

    private String creci;

    private UsuarioDTO usuario;

    public String getCreci() {
        return creci;
    }

    public void setCreci(String creci) {
        this.creci = creci;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }
}