package com.gubiogarcia.provaN2.controller;

import com.gubiogarcia.provaN2.dto.EmprestimoDTO;
import com.gubiogarcia.provaN2.entity.Emprestimos;
import com.gubiogarcia.provaN2.services.EmprestimosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emprestimos")
@CrossOrigin("*")
public class EmprestimoController {
    private final EmprestimosService emprestimosService;

    @Autowired
    public EmprestimoController(EmprestimosService emprestimosService) {
        this.emprestimosService = emprestimosService;
    }

    @GetMapping("/{id}")
    public Emprestimos findById(@PathVariable Long id) {
        return this.emprestimosService.findById(id);
    }

    @GetMapping("/ativos")
    public List<Emprestimos> listarAtivos() {
        return this.emprestimosService.emprestimosAtivos();
    }

    @GetMapping("/fechados")
    public List<Emprestimos> listarFechados() {
        return this.emprestimosService.emprestimosFechados();
    }

    @PostMapping("/registrar")
    public Emprestimos registrarEmprestimo(@RequestBody EmprestimoDTO emprestimo) {
        return this.emprestimosService.registrarEmprestimo(emprestimo);
    }

    @PostMapping("/devolver/{id}")
    public Emprestimos devolverEmprestimo(@PathVariable Long id) {
        return this.emprestimosService.registrarDevolucao(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.emprestimosService.delete(id);
    }
}
