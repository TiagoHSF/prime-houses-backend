package com.br.plataformacorretor10.model;

/**
 * Endereco
 *
 * @author Tiago
 * @date 1 de nov de 2023
 * */
public class EnderecoDTO {

    public Integer cep;

    public String endereco;

    public String bairro;

    public String cidade;

    public String estado;

    public Integer numero;

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

    public EnderecoDTO() {
    }

    public EnderecoDTO(Integer cep, String endereco, String bairro, String cidade, String estado, Integer numero) {
        this.cep = cep;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.numero = numero;
    }
}
