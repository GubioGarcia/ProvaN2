package com.gubiogarcia.provaN2.dto;

import com.gubiogarcia.provaN2.entity.Livro;
import com.gubiogarcia.provaN2.entity.Usuario;

import java.time.LocalDate;

public class EmprestimoDTO {
    private Livro livro;
    private Usuario usuarioDTO;

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Usuario getUsuarioDTO() {
        return usuarioDTO;
    }

    public void setUsuarioDTO(Usuario usuarioDTO) {
        this.usuarioDTO = usuarioDTO;
    }
}
