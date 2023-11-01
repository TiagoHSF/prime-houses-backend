package com.br.plataformacorretor10.corretor.imoveis.model.jpa;

import com.br.plataformacorretor10.corretor.imoveis.model.dto.ImovelDTO;
import com.br.plataformacorretor10.model.constants.FormasPagamento;
import com.br.plataformacorretor10.model.constants.TipoImovel;
import com.br.plataformacorretor10.model.jpa.GenericEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

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

    /* DETALHES AQUI */

    /* ENDEREÇO AQUI */

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

    public Imovel(final ImovelDTO imovelDTO) {
        this.setDataCriacao(LocalDateTime.now());
        this.titulo = imovelDTO.getTitulo();
        this.descrição = imovelDTO.getDescricao();
        this.tipo = imovelDTO.getTipo();
        this.seloVerificado = imovelDTO.getSeloVerificado();
        this.estrelasSelo = imovelDTO.getEstrelasSelo();
        this.formasPagamento = imovelDTO.getFormasPagamento();
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
}
