package com.br.plataformacorretor10.model.jpa;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

/**
 * The Class Corretor
 *
 * @author Tiago Ferreira.
 * @since 07/11/2023
 */
@Entity
@Table(name = "corretor")
@Cacheable
public class Corretor extends GenericEntity {

    @Column(name = "creci")
    private String creci;

    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id", foreignKey = @ForeignKey(name = "fk_corretor_x_usuario"))
    private Usuario usuario;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "empresa_id", foreignKey = @ForeignKey(name = "fk_corretor_x_empresa"))
    private Empresa empresa;

    @Column(name = "validado")
    private Boolean validado = false;

    public Corretor() {
    }

    public Corretor(final Usuario usuario, final String creci) {
        this.usuario = usuario;
        this.creci = creci;
    }

    public String getCreci() {
        return creci;
    }

    public void setCreci(String creci) {
        this.creci = creci;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Boolean getValidado() {
        return validado;
    }

    public void setValidado(Boolean validado) {
        this.validado = validado;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}