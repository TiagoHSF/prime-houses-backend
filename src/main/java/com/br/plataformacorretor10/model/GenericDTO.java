package com.br.plataformacorretor10.model;

import java.time.LocalDateTime;

/**
 * Generic DTO
 *
 * @author Tiago
 * @date 1 de nov de 2023
 * */
public class GenericDTO {

    public Long id;
    public LocalDateTime dataCriacao;

    public LocalDateTime dataDesativacao;

    public LocalDateTime dataAtualizacao;

    public GenericDTO(Long id, LocalDateTime dataCriacao, LocalDateTime dataAtualizacao) {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataDesativacao() {
        return dataDesativacao;
    }

    public void setDataDesativacao(LocalDateTime dataDesativacao) {
        this.dataDesativacao = dataDesativacao;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}
