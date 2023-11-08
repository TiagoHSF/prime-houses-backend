package com.br.plataformacorretor10.core.usuario.model.jpa;

import com.br.plataformacorretor10.core.model.constants.TipoUsuario;
import com.br.plataformacorretor10.core.model.jpa.Endereco;
import com.br.plataformacorretor10.core.model.jpa.GenericEntity;
import com.br.plataformacorretor10.core.usuario.model.dto.UsuarioDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * The Class Usuario
 *
 * @author Tiago Ferreira.
 * @since 03/11/2023
 */
@Entity
@Table(name = "usuario")
@Cacheable
public class Usuario extends GenericEntity {

    @Column(name = "nome")
    @NotNull(message = "Nome não informado!")
    private String nome;

    @Column(name = "sobrenome")
    @NotNull(message = "Sobrenome não informado!")
    private String sobrenome;

    @Column(name = "email", unique = true)
    @NotNull(message = "Email não informado!")
    private String email;

    @Column(name = "celular", unique = true)
    @NotNull(message = "Celular não informado!")
    private String celular;

    @Column(name = "data_nascimento")
    @NotNull(message = "Data de nascimento não informada!")
    private LocalDateTime dataNascimento;

    @Column(name = "documento", unique = true)
    @NotNull(message = "Documento não informado!")
    private String documento;

    @Column(name = "senha", nullable = false)
    @NotNull(message = "A senha não foi informada")
    @JsonIgnore
    private String senha;

    @Column(name = "token")
    @JsonIgnore
    private String token;

    @Column(name = "codigo_seguranca")
    private Integer codigoSeguranca;

    @Column(name = "codigo_seguranca_confirmado")
    private Boolean codigoSegurancaConfirmado = false;

    @Column(name = "tipo")
    @Enumerated(EnumType.STRING)
    private TipoUsuario tipo;

    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "endereco_id", foreignKey = @ForeignKey(name = "fk_usuario_x_endereco"))
    private Endereco endereco;

    public Usuario(final UsuarioDTO usuarioDTO){
        if(Objects.isNull(this.getDataCriacao())){
            this.setDataCriacao(LocalDateTime.now());
        }
        this.nome = usuarioDTO.getNome();
        this.sobrenome = usuarioDTO.getSobrenome();
        this.email = usuarioDTO.getEmail();
        this.celular = usuarioDTO.getCelular();
        this.dataNascimento = usuarioDTO.getDataNascimento();
        this.documento = usuarioDTO.getDocumento();
        this.criptografarSenha(usuarioDTO.getSenha());
        this.tipo = usuarioDTO.getTipo();
    }

    public Usuario() {

    }

    /**
     * Criptografar senha.
     *
     * @param senha the senha
     */
    public void criptografarSenha(final String senha) {
        Objects.requireNonNull(senha, "A senha não foi informada");
        if (senha.length() < 8) {
            throw new IllegalArgumentException("A senha deve conter no mínimo 8 caractéres");
        }
        if (!senha.matches(".*[A-Z].*")) {
            throw new IllegalArgumentException("A senha deve conter ao menos uma letra maiúscula");
        }
        if (!senha.matches(".*[a-z].*")) {
            throw new IllegalArgumentException("A senha deve conter ao menos uma letra minúscula");
        }
        if (!senha.matches(".*[0-9].*")) {
            throw new IllegalArgumentException("A senha deve conter ao menos um número");
        }
        this.setSenha(BCrypt.hashpw(senha, BCrypt.gensalt()));
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
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

    public TipoUsuario getTipo() {
        return tipo;
    }

    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}