package com.br.plataformacorretor10.model.jpa;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import jakarta.persistence.*;

/**
 * The Class GenericEntity.
 *
 * @author Lucas Mota Vieira
 * @since 30 de abr. de 2020
 */

@MappedSuperclass
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(content = Include.NON_NULL)
public abstract class GenericEntity implements Serializable, Comparable<GenericEntity> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    @Column(name = "data_desativacao")
    private LocalDateTime dataDesativacao;

    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao = LocalDateTime.now();

    public GenericEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public LocalDateTime getDataDesativacao() {
        return dataDesativacao;
    }

    public void setDataDesativacao(LocalDateTime dataDesativacao) {
        this.dataDesativacao = dataDesativacao;
    }

    public LocalDateTime getDataCriacao() {
        if(Objects.isNull(this.dataCriacao)){
            this.dataCriacao = LocalDateTime.now();
        }
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
        if(Objects.isNull(this.dataCriacao)){
            this.dataCriacao = LocalDateTime.now();
        }
    }

    /**
     * The compareTo.
     *
     * @param o the o
     * @return the int
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(final GenericEntity o) {
        if (o == null) {
            return 0;
        }
        if (o.getId() == null) {
            return 0;
        }
        if (this.getId() == null) {
            return 0;
        }
        return this.getId().compareTo(o.getId());
    }

}
