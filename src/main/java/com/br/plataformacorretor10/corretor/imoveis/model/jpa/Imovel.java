package com.br.plataformacorretor10.corretor.imoveis.model.jpa;

import com.br.plataformacorretor10.model.jpa.GenericEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "imovel")
@Cacheable
public class Imovel extends GenericEntity {

    @Column(name = "titulo")
    @NotNull(message = "Título não informado!")
    public String titulo;

    @Column(name = "descricao")
    @NotNull(message = "Descrição não informada!")
    public String descrição;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
