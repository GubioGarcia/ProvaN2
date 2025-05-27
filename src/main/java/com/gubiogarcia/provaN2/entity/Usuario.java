package com.gubiogarcia.provaN2.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column(name = "nome", length = 100)
    private String nome;

    @Column(name = "matricula", length = 20)
    private String matricula;

    @Column(name = "curso", length = 100)
    private String curso;

    public Usuario() {
    }

    public Usuario(Long id, String nome, String matricula, String curso) {
        Id = id;
        this.nome = nome;
        this.matricula = matricula;
        this.curso = curso;
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

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(Id, usuario.Id) && Objects.equals(nome, usuario.nome) && Objects.equals(matricula, usuario.matricula) && Objects.equals(curso, usuario.curso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, nome, matricula, curso);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "Id=" + Id +
                ", nome='" + nome + '\'' +
                ", matricula='" + matricula + '\'' +
                ", curso='" + curso + '\'' +
                '}';
    }
}
