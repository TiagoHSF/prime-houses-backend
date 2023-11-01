package com.br.plataformacorretor10.corretor.imoveis.model.dto;

import com.br.plataformacorretor10.model.EnderecoDTO;
import com.br.plataformacorretor10.model.GenericDTO;
import com.br.plataformacorretor10.model.constants.FormasPagamento;
import com.br.plataformacorretor10.model.constants.TipoImovel;
import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.NotNull;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;

/**
 * Imóvel
 *
 * @author Tiago
 * @date 1 de nov de 2023
 * */
public class ImovelDTO extends GenericDTO {

    @NotNull(message = "Título não informado!")
    public String titulo;

    @NotNull(message = "Descrição não informada!")
    public String descricao;

    public DetalhesImovelDTO detalhes;

    @NotNull(message = "Endereço não informado!")
    public EnderecoDTO endereco;
    @NotNull(message = "Tipo do imóvel não informado!")
    public TipoImovel tipo;

    public Boolean seloVerificado;

    public Integer estrelasSelo;

    @NotNull(message = "Forma de pagamento não informada!")
    public FormasPagamento formasPagamento;

    public ImovelDTO(){

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
