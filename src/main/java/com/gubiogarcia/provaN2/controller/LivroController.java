package com.gubiogarcia.provaN2.controller;

import com.gubiogarcia.provaN2.dto.LivroDTO;
import com.gubiogarcia.provaN2.entity.Livro;
import com.gubiogarcia.provaN2.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/livros")
@CrossOrigin("*")
public class LivroController {
    private final LivroService livroService;

    @Autowired
    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping
    public List<Livro> findAll() {
        return this.livroService.findAll();
    }

    @GetMapping("/{id}")
    public Livro findById(@PathVariable Long id) {
        return this.livroService.findById(id);
    }

    @PostMapping
    public Livro save(@RequestBody LivroDTO livro) {
        return this.livroService.save(livro);
    }

    @PutMapping
    public Livro update(@RequestBody Livro livro) {
        return this.livroService.update(livro);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.livroService.delete(id);
    }
}
