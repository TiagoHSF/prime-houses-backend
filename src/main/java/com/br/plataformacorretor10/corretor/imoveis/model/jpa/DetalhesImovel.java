package com.br.plataformacorretor10.corretor.imoveis.model.jpa;

import com.br.plataformacorretor10.corretor.imoveis.model.dto.DetalhesImovelDTO;
import com.br.plataformacorretor10.model.jpa.GenericEntity;
import jakarta.persistence.Cacheable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "detalhes_imovel")
@Cacheable
public class DetalhesImovel extends GenericEntity {
    @Column(name = "tamanho_mts_quadrados")
    @NotNull(message = "Tamanho do terreno não informado!")
    public Long tamanhoMtsQuadrados;

    @Column(name = "quantidade_quartos")
    public Long quantidadeQuartos;

    @Column(name = "quantidade_banheiros")
    public Long quantidadeBanheiros;

    @Column(name = "quantidade_salas")
    public Long quantidadeSalas;

    @Column(name = "quantidade_cozinhas")
    public Long quantidadeCozinhas;

    @Column(name = "quantidade_suites")
    public Long quantidadeSuites;

    @Column(name = "quantidade_areas_externas")
    public Long quantidadeAreasExternas;

    @Column(name = "possui_piscina")
    public Boolean piscina;

    @Column(name = "possui_area_churrasco")
    public Boolean areaDeChurrasco;

    @Column(name = "quantidade_vagas_garagem")
    public Long quantidadeVagasGaragem;

    @Column(name = "terreno_nivelado")
    public Boolean terrenoNivelado; //TERRENO

    @Column(name = "possui_agua")
    public Boolean aguaLigada; //TERRENO/BARRACAO

    @Column(name = "possui_acesso_pavimentado")
    public Boolean acessoPavimentado; //TERRENO/BARRACAO

    @Column(name = "possui_energia_ligada")
    public Boolean energiaLigada; //TERRENO/BARRACAO

    public DetalhesImovel(DetalhesImovelDTO detalhes) {
        this.setDataCriacao(LocalDateTime.now());
        this.tamanhoMtsQuadrados = detalhes.getTamanhoMtsQuadrados();
        this.quantidadeQuartos = detalhes.getQuantidadeQuartos();
        this.quantidadeBanheiros = detalhes.getQuantidadeBanheiros();
        this.quantidadeSalas = detalhes.getQuantidadeSalas();
        this.quantidadeCozinhas = detalhes.getQuantidadeCozinhas();
        this.quantidadeSuites = detalhes.getQuantidadeSuites();
        this.quantidadeAreasExternas = detalhes.getQuantidadeAreasExternas();
        this.piscina
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

    public Long getQuantidadeCozinhas() {
        return quantidadeCozinhas;
    }

    public void setQuantidadeCozinhas(Long quantidadeCozinhas) {
        this.quantidadeCozinhas = quantidadeCozinhas;
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

    public Boolean getTerrenoNivelado() {
        return terrenoNivelado;
    }

    public void setTerrenoNivelado(Boolean terrenoNivelado) {
        this.terrenoNivelado = terrenoNivelado;
    }

    public Boolean getAguaLigada() {
        return aguaLigada;
    }

    public void setAguaLigada(Boolean aguaLigada) {
        this.aguaLigada = aguaLigada;
    }

    public Boolean getAcessoPavimentado() {
        return acessoPavimentado;
    }

    public void setAcessoPavimentado(Boolean acessoPavimentado) {
        this.acessoPavimentado = acessoPavimentado;
    }

    public Boolean getEnergiaLigada() {
        return energiaLigada;
    }

    public void setEnergiaLigada(Boolean energiaLigada) {
        this.energiaLigada = energiaLigada;
    }
}
