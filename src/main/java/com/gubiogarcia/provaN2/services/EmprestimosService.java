package com.gubiogarcia.provaN2.services;

import com.gubiogarcia.provaN2.dto.EmprestimoDTO;
import com.gubiogarcia.provaN2.entity.Emprestimos;
import com.gubiogarcia.provaN2.entity.Livro;
import com.gubiogarcia.provaN2.entity.Status;
import com.gubiogarcia.provaN2.repository.EmprestimosRepository;
import com.gubiogarcia.provaN2.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmprestimosService {
    private final EmprestimosRepository emprestimosRepository;

    @Autowired
    public EmprestimosService(EmprestimosRepository emprestimosRepository) {
        this.emprestimosRepository = emprestimosRepository;
    }

    public Emprestimos findById(Long id) {
        return this.emprestimosRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Emprestimo não encontrado"));
    }

    public List<Emprestimos> emprestimosAtivos() {
        return this.emprestimosRepository.findByAtivoTrue();
    }

    public List<Emprestimos> emprestimosFechados() {
        return this.emprestimosRepository.findByAtivoFalse();
    }

    public Emprestimos registrarEmprestimo(EmprestimoDTO emprestimodto) {
        Emprestimos emprestimo = new Emprestimos();
        emprestimo.setUsuario(emprestimodto.getUsuario());
        emprestimo.setLivro(emprestimodto.getLivro());
        emprestimo.setDataEmprestimo(LocalDate.now());
        emprestimo.setDataDevolucao(LocalDate.now().plusDays(7));
        emprestimo.setStatus(Status.EMPRESTADO);
        emprestimo.setAtivo(true);

        return this.emprestimosRepository.save(emprestimo);
    }

    public Emprestimos registrarDevolucao(Long id) {
        Emprestimos emprestimo = findById(id);
        if (emprestimo == null) throw new RuntimeException("Emprestimo não encontrado");

        emprestimo.setStatus(Status.DEVOLVIDO);
        emprestimo.setDataDevolucao(LocalDate.now());
        emprestimo.setAtivo(false);

        return this.emprestimosRepository.save(emprestimo);
    }

    public void delete(Long id) {
        Emprestimos emprestimos = findById(id);
        emprestimos.setStatus(Status.DELETADO);
    }
}
