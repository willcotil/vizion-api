package com.cognis.buildup_api.controller;

import com.cognis.buildup_api.core.usuario.Usuario;
import com.cognis.buildup_api.repository.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepo usuarioRepo;

    @PutMapping
    public Usuario atualizar(@RequestBody Usuario body){
        return usuarioRepo.save(body);
    }

    @DeleteMapping
    public void deletar(@RequestBody Usuario body){
        usuarioRepo.delete(body);
    }

    @GetMapping
    public ResponseEntity<Usuario> buscarPorId(@RequestBody Integer id){
        Optional<Usuario> buscarPorId = usuarioRepo.findById(id);
        return ResponseEntity.of(buscarPorId);
    }

    @PostMapping
    public Usuario inserirDados(@RequestBody Usuario body){
        return usuarioRepo.save(body);
    }

}
