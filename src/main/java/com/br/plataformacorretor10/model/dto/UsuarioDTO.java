package com.br.plataformacorretor10.model.dto;

import com.br.plataformacorretor10.model.constants.TipoUsuario;
import com.br.plataformacorretor10.model.dto.EnderecoDTO;
import com.br.plataformacorretor10.model.dto.GenericDTO;

import java.time.LocalDateTime;

/**
 * The Class UsuarioDTO
 *
 * @author Tiago Ferreira.
 * @since 03/11/2023
 */
public class UsuarioDTO extends GenericDTO {

    private String nome;

    private String sobrenome;

    private String email;

    private String celular;

    private LocalDateTime dataNascimento;

    private String documento;

    private String senha;

    private Integer codigoSeguranca;

    private Boolean codigoSegurancaConfirmado;

    private TipoUsuario tipo;

    private EnderecoDTO enderecoDTO;

    private String creci;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDateTime dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getSenha() {
        return senha;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public TipoUsuario getTipo() {
        return tipo;
    }

    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Integer getCodigoSeguranca() {
        return codigoSeguranca;
    }

    public void setCodigoSeguranca(Integer codigoSeguranca) {
        this.codigoSeguranca = codigoSeguranca;
    }

    public Boolean getCodigoSegurancaConfirmado() {
        return codigoSegurancaConfirmado;
    }

    public void setCodigoSegurancaConfirmado(Boolean codigoSegurancaConfirmado) {
        this.codigoSegurancaConfirmado = codigoSegurancaConfirmado;
    }

    public EnderecoDTO getEnderecoDTO() {
        return enderecoDTO;
    }

    public void setEnderecoDTO(EnderecoDTO enderecoDTO) {
        this.enderecoDTO = enderecoDTO;
    }

    public String getCreci() {
        return creci;
    }

    public void setCreci(String creci) {
        this.creci = creci;
    }
}