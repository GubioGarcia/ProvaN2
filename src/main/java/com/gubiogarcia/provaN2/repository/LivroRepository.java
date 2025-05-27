package com.gubiogarcia.provaN2.repository;

import com.gubiogarcia.provaN2.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
}
