package com.br.plataformacorretor10.core.corretor.imoveis.model.jpa;

import com.br.plataformacorretor10.core.corretor.imoveis.model.dto.ImovelDTO;
import com.br.plataformacorretor10.core.model.constants.FormasPagamento;
import com.br.plataformacorretor10.core.model.constants.TipoImovel;
import com.br.plataformacorretor10.core.model.jpa.Endereco;
import com.br.plataformacorretor10.core.model.jpa.GenericEntity;
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
    private Endereco endereco;

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
}