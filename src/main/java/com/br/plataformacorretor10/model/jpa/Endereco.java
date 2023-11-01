package com.br.plataformacorretor10.model.jpa;

import com.br.plataformacorretor10.model.dto.EnderecoDTO;
import jakarta.persistence.Cacheable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "endereco")
@Cacheable
public class Endereco extends GenericEntity {

    @Column(name = "cep")
    @NotNull(message = "CEP não informado!")
    public Integer cep;

    @Column(name = "endereco")
    @NotNull(message = "Endereço não informado!")
    public String endereco;

    @Column(name = "bairro")
    @NotNull(message = "Bairro não informado!")
    public String bairro;

    @Column(name = "cidade")
    @NotNull(message = "Cidade não informada!")
    public String cidade;

    @Column(name = "estado")
    @NotNull(message = "Estado não informado!")
    public String estado;

    @Column(name = "numero")
    @NotNull(message = "Numero não informado!")
    public Integer numero;

    @Column(name = "complemento")
    @NotNull(message = "Complemento não informado!")
    public String complemento;

    public Endereco() {
    }

    public Endereco(EnderecoDTO enderecoDTO) {
        this.setDataCriacao(LocalDateTime.now());
        this.cep = enderecoDTO.getCep();
        this.endereco = enderecoDTO.getEndereco();
        this.bairro = enderecoDTO.getBairro();
        this.cidade = enderecoDTO.getCidade();
        this.estado = enderecoDTO.getEstado();
        this.numero = enderecoDTO.getNumero();
        this.complemento = enderecoDTO.getComplemento();
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

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

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}
