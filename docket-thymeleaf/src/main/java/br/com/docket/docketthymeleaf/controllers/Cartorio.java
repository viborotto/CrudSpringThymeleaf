package br.com.docket.docketthymeleaf.controllers;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cartorios")
public class Cartorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nome;

    protected Cartorio() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}