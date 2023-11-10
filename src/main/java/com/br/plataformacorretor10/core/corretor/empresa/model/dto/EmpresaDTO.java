package com.br.plataformacorretor10.core.corretor.empresa.model.dto;

import com.br.plataformacorretor10.core.model.constants.StatusEmpresa;
import com.br.plataformacorretor10.core.model.dto.GenericDTO;

/**
 * The Class EmpresaDTO
 *
 * @author Tiago Ferreira.
 * @since 10/11/2023
 */
public class EmpresaDTO extends GenericDTO {

    private String nome;

    private String razaoSocial;

    private String documento;

    private StatusEmpresa statusEmpresa;

    public EmpresaDTO() {
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public StatusEmpresa getStatusEmpresa() {
        return statusEmpresa;
    }

    public void setStatusEmpresa(StatusEmpresa statusEmpresa) {
        this.statusEmpresa = statusEmpresa;
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