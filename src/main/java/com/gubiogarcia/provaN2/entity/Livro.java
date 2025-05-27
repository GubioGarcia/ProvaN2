package com.gubiogarcia.provaN2.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column(name = "nome", length = 100)
    private String nome;

    @Column(name = "autor", length = 100)
    private String autor;

    @Column(name = "editora", length = 100)
    private String editora;

    @Column(name = "anoDePublicacao", length = 4)
    private int anoDePublicacao;

    public Livro() {}

    public Livro(Long id, String nome, String autor, String editora, int anoDePublicacao) {
        Id = id;
        this.nome = nome;
        this.autor = autor;
        this.editora = editora;
        this.anoDePublicacao = anoDePublicacao;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public int getAnoDePublicacao() {
        return anoDePublicacao;
    }

    public void setAnoDePublicacao(int anoDePublicacao) {
        this.anoDePublicacao = anoDePublicacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return anoDePublicacao == livro.anoDePublicacao && Objects.equals(Id, livro.Id) && Objects.equals(nome, livro.nome) && Objects.equals(autor, livro.autor) && Objects.equals(editora, livro.editora);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, nome, autor, editora, anoDePublicacao);
    }

    @Override
    public String toString() {
        return "Livro{" +
                "Id=" + Id +
                ", nome='" + nome + '\'' +
                ", autor='" + autor + '\'' +
                ", editora='" + editora + '\'' +
                ", anoDePublicacao=" + anoDePublicacao +
                '}';
    }
}
