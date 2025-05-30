package com.gubiogarcia.provaN2.dto;

import com.gubiogarcia.provaN2.entity.Livro;
import com.gubiogarcia.provaN2.entity.Usuario;

import java.time.LocalDate;

public class EmprestimoDTO {
    private Long livroId;
    private Long usuarioId;

    public Long getLivroId() {
        return livroId;
    }

    public void setLivroId(Long livroId) {
        this.livroId = livroId;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}
