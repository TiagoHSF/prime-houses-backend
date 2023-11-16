package com.br.plataformacorretor10.model.jpa;

import com.br.plataformacorretor10.model.dto.ImovelDTO;
import com.br.plataformacorretor10.model.constants.FormasPagamento;
import com.br.plataformacorretor10.model.constants.StatusImovel;
import com.br.plataformacorretor10.model.constants.TipoImovel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "imovel")
@Cacheable
public class Imovel extends GenericEntity {

    @Column(name = "titulo")
    @NotNull(message = "Título não informado!")
    private String titulo;

    @Column(name = "descricao")
    @NotNull(message = "Descrição não informada!")
    private String descrição;

    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "detalhe_id", foreignKey = @ForeignKey(name = "fk_imovel_x_detalhe_imovel"))
    private DetalhesImovel detalhes;

    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "endereco_id", foreignKey = @ForeignKey(name = "fk_imovel_x_endereco"))
    @NotNull(message = "Endereço não informado!")
    private Endereco endereco;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "corretor_id", foreignKey = @ForeignKey(name = "fk_imovel_x_corretor"))
    @NotNull(message = "Corretor não informado!")
    private Corretor corretor;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "empresa_id", foreignKey = @ForeignKey(name = "fk_imovel_x_empresa"))
    @NotNull(message = "Empresa não informada!")
    private Empresa empresa;

    @Column(name = "tipo")
    @Enumerated(EnumType.STRING)
    private TipoImovel tipo;

    @Column(name = "selo_verificado")
    public Boolean seloVerificado;

    @Column(name = "estrelas_selo")
    public Integer estrelasSelo;

    @Column(name = "forma_pagamento")
    @Enumerated(EnumType.STRING)
    public FormasPagamento formasPagamento;

    @Column(name = "valor")
    public Double valor;

    @Column(name = "validado")
    public Boolean validado = false;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusImovel status = StatusImovel.AGUARDANDO_APROVACAO;

    @Column(name = "porcentagem_comissao")
    public Double porcentagemComissao;

    public Imovel(final ImovelDTO imovelDTO) {
        if(Objects.isNull(this.getDataCriacao())){
            this.setDataCriacao(LocalDateTime.now());
        }
        this.titulo = imovelDTO.getTitulo();
        this.descrição = imovelDTO.getDescricao();
        this.tipo = imovelDTO.getTipo();
        this.seloVerificado = imovelDTO.getSeloVerificado();
        this.estrelasSelo = imovelDTO.getEstrelasSelo();
        this.formasPagamento = imovelDTO.getFormasPagamento();
        this.valor = imovelDTO.getValor();
    }

    public Imovel() {

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescrição() {
        return descrição;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

    public TipoImovel getTipoImovel() {
        return tipo;
    }

    public void setTipoImovel(TipoImovel tipoImovel) {
        this.tipo = tipoImovel;
    }

    public Boolean getSeloVerificado() {
        return seloVerificado;
    }

    public void setSeloVerificado(Boolean seloVerificado) {
        this.seloVerificado = seloVerificado;
    }

    public Integer getEstrelasSelo() {
        return estrelasSelo;
    }

    public void setEstrelasSelo(Integer estrelasSelo) {
        this.estrelasSelo = estrelasSelo;
    }

    public FormasPagamento getFormasPagamento() {
        return formasPagamento;
    }

    public void setFormasPagamento(FormasPagamento formasPagamento) {
        this.formasPagamento = formasPagamento;
    }

    public TipoImovel getTipo() {
        return tipo;
    }

    public void setTipo(TipoImovel tipo) {
        this.tipo = tipo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public DetalhesImovel getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(DetalhesImovel detalhes) {
        this.detalhes = detalhes;
    }

    public Boolean getValidado() {
        return validado;
    }

    public void setValidado(Boolean validado) {
        this.validado = validado;
    }

    public Corretor getCorretor() {
        return corretor;
    }

    public void setCorretor(Corretor corretor) {
        this.corretor = corretor;
    }

    public StatusImovel getStatus() {
        return status;
    }

    public void setStatus(StatusImovel status) {
        this.status = status;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Double getPorcentagemComissao() {
        return porcentagemComissao;
    }

    public void setPorcentagemComissao(Double porcentagemComissao) {
        this.porcentagemComissao = porcentagemComissao;
    }
}
