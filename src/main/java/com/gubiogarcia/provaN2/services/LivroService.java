package com.gubiogarcia.provaN2.services;

import com.gubiogarcia.provaN2.dto.LivroDTO;
import com.gubiogarcia.provaN2.entity.Livro;
import com.gubiogarcia.provaN2.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {
    private final LivroRepository livroRepository;

    @Autowired
    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public List<Livro> findAll() {
        return this.livroRepository.findAll();
    }

    public Livro findById(Long id) {
        return this.livroRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Livro não encontrado"));
    }

    public Livro save(LivroDTO livrodto) {
        if (livrodto.getAnoDePublicacao() < 0 || livrodto.getAnoDePublicacao() > 2025)
            throw new RuntimeException("Ano de publicação inválido");
        if (livrodto.getNome().trim().isEmpty() || livrodto.getAutor().trim().isEmpty() || livrodto.getEditora().trim().isEmpty())
            throw new RuntimeException("Valores obrigatórios não preenchidos.");

        Livro livro = new Livro();

        livro.setNome(livrodto.getNome());
        livro.setAutor(livrodto.getAutor());
        livro.setEditora(livrodto.getEditora());
        livro.setAnoDePublicacao(livrodto.getAnoDePublicacao());

        return this.livroRepository.save(livro);
    }

    public Livro update(Livro livro) {
        if (livro.getAnoDePublicacao() < 0 || livro.getAnoDePublicacao() > 2025)
            throw new RuntimeException("Ano de publicação inválido");
        if (livro.getNome().trim().isEmpty() || livro.getAutor().trim().isEmpty() || livro.getEditora().trim().isEmpty())
            throw new RuntimeException("Valores obrigatórios não preenchidos.");


        return this.livroRepository.save(livro);
    }

    public void delete(Long id) {
        this.livroRepository.deleteById(id);
    }
}
