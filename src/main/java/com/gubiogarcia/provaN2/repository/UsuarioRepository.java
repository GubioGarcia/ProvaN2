package com.gubiogarcia.provaN2.repository;

import com.gubiogarcia.provaN2.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByMatricula(String matricula);
}
