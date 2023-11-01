package com.br.plataformacorretor10.corretor.imoveis.model.dto;

/**
 * Detalhes imóvel
 *
 * @author Tiago
 * @date 1 de nov de 2023
 * */
public class DetalhesImovelDTO {

    public Long tamanhoMtsQuadrados;

    public Long quantidadeQuartos;

    public Long quantidadeBanheiros;

    public Long quantidadeSalas;

    public Long quantidadeSuites;

    public Long quantidadeAreasExternas;

    public Boolean piscina;

    public Boolean areaDeChurrasco;

    public Long quantidadeVagasGaragem;

    public DetalhesImovelDTO() {
    }

    public Long getTamanhoMtsQuadrados() {
        return tamanhoMtsQuadrados;
    }

    public void setTamanhoMtsQuadrados(Long tamanhoMtsQuadrados) {
        this.tamanhoMtsQuadrados = tamanhoMtsQuadrados;
    }

    public Long getQuantidadeQuartos() {
        return quantidadeQuartos;
    }

    public void setQuantidadeQuartos(Long quantidadeQuartos) {
        this.quantidadeQuartos = quantidadeQuartos;
    }

    public Long getQuantidadeBanheiros() {
        return quantidadeBanheiros;
    }

    public void setQuantidadeBanheiros(Long quantidadeBanheiros) {
        this.quantidadeBanheiros = quantidadeBanheiros;
    }

    public Long getQuantidadeSalas() {
        return quantidadeSalas;
    }

    public void setQuantidadeSalas(Long quantidadeSalas) {
        this.quantidadeSalas = quantidadeSalas;
    }

    public Long getQuantidadeSuites() {
        return quantidadeSuites;
    }

    public void setQuantidadeSuites(Long quantidadeSuites) {
        this.quantidadeSuites = quantidadeSuites;
    }

    public Long getQuantidadeAreasExternas() {
        return quantidadeAreasExternas;
    }

    public void setQuantidadeAreasExternas(Long quantidadeAreasExternas) {
        this.quantidadeAreasExternas = quantidadeAreasExternas;
    }

    public Boolean getPiscina() {
        return piscina;
    }

    public void setPiscina(Boolean piscina) {
        this.piscina = piscina;
    }

    public Boolean getAreaDeChurrasco() {
        return areaDeChurrasco;
    }

    public void setAreaDeChurrasco(Boolean areaDeChurrasco) {
        this.areaDeChurrasco = areaDeChurrasco;
    }

    public Long getQuantidadeVagasGaragem() {
        return quantidadeVagasGaragem;
    }

    public void setQuantidadeVagasGaragem(Long quantidadeVagasGaragem) {
        this.quantidadeVagasGaragem = quantidadeVagasGaragem;
    }
}
