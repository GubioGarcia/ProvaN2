package com.gubiogarcia.provaN2.controller;

import com.gubiogarcia.provaN2.dto.UsuarioDTO;
import com.gubiogarcia.provaN2.entity.Usuario;
import com.gubiogarcia.provaN2.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin("*")
public class UsuarioController {
    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> findAll() {
        return this.usuarioService.findAll();
    }

    @GetMapping("/{id}")
    public Usuario findById(@PathVariable Long id) {
        return this.usuarioService.findById(id);
    }

    @PostMapping
    public Usuario save(@RequestBody UsuarioDTO usuario) {
        return this.usuarioService.save(usuario);
    }

    @PutMapping
    public Usuario update(@RequestBody Usuario usuario) {
        return this.usuarioService.update(usuario);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.usuarioService.delete(id);
    }
}
