package com.br.plataformacorretor10.core.corretor.empresa.model.jpa;

import com.br.plataformacorretor10.core.corretor.empresa.model.dto.EmpresaDTO;
import com.br.plataformacorretor10.core.model.constants.StatusEmpresa;
import com.br.plataformacorretor10.core.model.jpa.GenericEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

/**
 * The Class Empresa
 *
 * @author Tiago Ferreira.
 * @since 10/11/2023
 */
@Entity
@Table(name = "empresa")
@Cacheable
public class Empresa extends GenericEntity {

    @Column(name = "nome")
    @NotNull(message = "Nome da empresa não informada!")
    private String nome;

    @Column(name = "razao_social") //OBRIGATÓRIO SOMENTE PARA EMPRESAS COM CNPJ
    private String razaoSocial;

    @Column(name = "documento", unique = true)
    private String documento;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusEmpresa status = StatusEmpresa.INFORMAL;

    public Empresa() {

    }

    public Empresa(EmpresaDTO empresaDTO){
        if(Objects.nonNull(empresaDTO.getDocumento()) && empresaDTO.getDocumento() != ""){
            this.documento = empresaDTO.getDocumento();
            this.status = StatusEmpresa.FORMAL;
        }
        this.nome = empresaDTO.getNome();
        this.razaoSocial = empresaDTO.getRazaoSocial();
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public StatusEmpresa getStatus() {
        return status;
    }

    public void setStatus(StatusEmpresa status) {
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }
}