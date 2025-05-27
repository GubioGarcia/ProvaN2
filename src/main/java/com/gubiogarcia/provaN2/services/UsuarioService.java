package com.gubiogarcia.provaN2.services;

import com.gubiogarcia.provaN2.dto.UsuarioDTO;
import com.gubiogarcia.provaN2.entity.Usuario;
import com.gubiogarcia.provaN2.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> findAll() {
        return this.usuarioRepository.findAll();
    }

    public Usuario findById(Long id) {
        return this.usuarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));
    }

    public Usuario findByMatricula(String matricula) {
        return this.usuarioRepository.findByMatricula(matricula);
    }

    public Usuario save(UsuarioDTO usuariodto) {
        if (usuariodto.getNome().trim().isEmpty() || usuariodto.getCurso().trim().isEmpty() || usuariodto.getMatricula().trim().isEmpty())
            throw new RuntimeException("Valores obrigatórios não preenchidos");

        Usuario usuarioAux = this.usuarioRepository.findByMatricula(usuariodto.getMatricula());
        //if (usuario.getCurso() == usuariodto.getCurso()) throw new RuntimeException("Já existe usuário com está matrícula para este curso.");
        if (usuarioAux != null) throw new RuntimeException("Já existe usuário com está matrícula.");

        Usuario usuario = new Usuario();
        usuario.setNome(usuariodto.getNome());
        usuario.setMatricula(usuariodto.getMatricula());
        usuario.setCurso(usuariodto.getCurso());

        return this.usuarioRepository.save(usuario);
    }

    public Usuario update(Usuario usuario) {
        return this.usuarioRepository.save(usuario);
    }

    public void delete(Long id) {
        this.usuarioRepository.deleteById(id);
    }
}
