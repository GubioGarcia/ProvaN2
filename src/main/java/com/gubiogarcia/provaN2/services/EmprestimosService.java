package com.gubiogarcia.provaN2.services;

import com.gubiogarcia.provaN2.dto.EmprestimoDTO;
import com.gubiogarcia.provaN2.entity.Emprestimos;
import com.gubiogarcia.provaN2.entity.Livro;
import com.gubiogarcia.provaN2.entity.Status;
import com.gubiogarcia.provaN2.entity.Usuario;
import com.gubiogarcia.provaN2.repository.EmprestimosRepository;
import com.gubiogarcia.provaN2.repository.LivroRepository;
import com.gubiogarcia.provaN2.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EmprestimosService {
    private final EmprestimosRepository emprestimosRepository;
    private final UsuarioRepository usuarioRepository;
    private final LivroRepository livroRepository;

    public EmprestimosService(EmprestimosRepository emprestimosRepository, UsuarioRepository usuarioRepository, LivroRepository livroRepository) {
        this.emprestimosRepository = emprestimosRepository;
        this.usuarioRepository = usuarioRepository;
        this.livroRepository = livroRepository;
    }

    public Emprestimos findById(Long id) {
        return this.emprestimosRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Emprestimo não encontrado"));
    }

    public List<Emprestimos> emprestimosAtivos() {
        return this.emprestimosRepository.findByStatus(Status.EMPRESTADO);
    }

    public List<Emprestimos> emprestimosFechados() {
        return this.emprestimosRepository.findByStatus(Status.DEVOLVIDO);
    }

    public Emprestimos registrarEmprestimo(EmprestimoDTO emprestimodto) {
        if (emprestimosRepository.existsByLivroIdAndStatus(emprestimodto.getLivroId(), Status.EMPRESTADO))
            throw new IllegalArgumentException("Este livro já está emprestado.");

        Long emprestimosAtivosDoUsuario = emprestimosRepository.countByUsuarioIdAndStatus(emprestimodto.getUsuarioId(), Status.EMPRESTADO);
        if (emprestimosAtivosDoUsuario >= 3)
            throw new IllegalArgumentException("Este usuário já possui 3 livros emprestados.");

        Livro livro = livroRepository.findById(emprestimodto.getLivroId())
                .orElseThrow(() -> new IllegalArgumentException("Livro não encontrado"));;
        Usuario usuario = usuarioRepository.findById(emprestimodto.getUsuarioId())
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));;

        Emprestimos emprestimo = new Emprestimos();
        emprestimo.setUsuario(usuario);
        emprestimo.setLivro(livro);
        emprestimo.setDataEmprestimo(LocalDate.now());
        emprestimo.setDataDevolucaoPrevista(LocalDate.now().plusDays(7));
        emprestimo.setStatus(Status.EMPRESTADO);

        return this.emprestimosRepository.save(emprestimo);
    }

    public Emprestimos registrarDevolucao(Long id) {
        Emprestimos emprestimo = findById(id);

        emprestimo.setStatus(Status.DEVOLVIDO);
        emprestimo.setDataDevolucao(LocalDate.now());

        return this.emprestimosRepository.save(emprestimo);
    }

    public void delete(Long id) {
        Emprestimos emprestimos = findById(id);
        emprestimos.setStatus(Status.DELETADO);
        emprestimosRepository.save(emprestimos);
    }
}
