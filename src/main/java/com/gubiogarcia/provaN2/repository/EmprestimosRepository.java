package com.gubiogarcia.provaN2.repository;

import com.gubiogarcia.provaN2.entity.Emprestimos;
import com.gubiogarcia.provaN2.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmprestimosRepository extends JpaRepository<Emprestimos, Long> {
    List<Emprestimos> findByStatus(Status status);
    boolean existsByLivroIdAndStatus(Long livroId, Status status);
    long countByUsuarioIdAndStatus(Long usuarioId, Status status);
}
