package com.gubiogarcia.provaN2.dto;

import com.gubiogarcia.provaN2.entity.Livro;
import com.gubiogarcia.provaN2.entity.Usuario;

import java.time.LocalDate;

public class EmprestimoDTO {
    private Livro livro;
    private Usuario usuario;

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
