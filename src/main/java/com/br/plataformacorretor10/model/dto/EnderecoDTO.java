package com.br.plataformacorretor10.model.dto;

import jakarta.validation.constraints.NotNull;

/**
 * Endereco
 *
 * @author Tiago
 * @date 1 de nov de 2023
 * */
public class EnderecoDTO {

    @NotNull(message = "CEP não informado!")
    public Integer cep;

    @NotNull(message = "Endereço não informado!")
    public String endereco;

    @NotNull(message = "Bairro não informado!")
    public String bairro;

    @NotNull(message = "Cidade não informada!")
    public String cidade;

    @NotNull(message = "Estado não informado!")
    public String estado;

    @NotNull(message = "Numero não informado!")
    public Integer numero;

    @NotNull(message = "Complemento não informado!")
    public String complemento;

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public EnderecoDTO() {
    }

    public EnderecoDTO(Integer cep, String endereco, String bairro, String cidade, String estado, Integer numero, final String complemento) {
        this.cep = cep;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.numero = numero;
        this.complemento = complemento;
    }
}
