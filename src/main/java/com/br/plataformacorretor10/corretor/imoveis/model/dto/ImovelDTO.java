package com.br.plataformacorretor10.corretor.imoveis.model.dto;

import com.br.plataformacorretor10.model.EnderecoDTO;
import com.br.plataformacorretor10.model.GenericDTO;
import com.br.plataformacorretor10.model.constants.FormasPagamento;
import com.br.plataformacorretor10.model.constants.TipoImovel;

import java.time.LocalDateTime;

/**
 * Imóvel
 *
 * @author Tiago
 * @date 1 de nov de 2023
 * */
public class ImovelDTO extends GenericDTO {

    public String titulo;

    public String descricao;

    public DetalhesImovelDTO detalhes;

    public EnderecoDTO endereco;
    public TipoImovel tipo;

    public Boolean seloVerificado;

    public Integer estrelasSelo;

    public FormasPagamento formasPagamento;

    public ImovelDTO(){
        super(null, null, null);
    }

    public ImovelDTO(
        Long id,
        LocalDateTime dataCriacao,
        LocalDateTime dataAtualizacao,
        String titulo,
        String descricao,
        DetalhesImovelDTO detalhes,
        EnderecoDTO endereco,
        TipoImovel tipo,
        Boolean seloVerificado,
        Integer estrelasSelo) {
        super(null, null, null);
        this.titulo = titulo;
        this.descricao = descricao;
        this.detalhes = detalhes;
        this.endereco = endereco;
        this.tipo = tipo;
        this.seloVerificado = seloVerificado;
        this.estrelasSelo = estrelasSelo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public DetalhesImovelDTO getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(DetalhesImovelDTO detalhes) {
        this.detalhes = detalhes;
    }

    public TipoImovel getTipo() {
        return tipo;
    }

    public void setTipo(TipoImovel tipo) {
        this.tipo = tipo;
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

    public EnderecoDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDTO endereco) {
        this.endereco = endereco;
    }
}
