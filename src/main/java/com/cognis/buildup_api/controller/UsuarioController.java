package com.cognis.buildup_api.controller;

import com.cognis.buildup_api.core.usuario.Usuario;
import com.cognis.buildup_api.core.usuario.UsuarioRequest;
import com.cognis.buildup_api.repository.UsuarioRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    @Autowired
    private UsuarioRepo usuarioRepo;

    @Autowired
    private ModelMapper mapper;

    private final PasswordEncoder encoder;

    @PutMapping
    public Usuario atualizar(@RequestBody UsuarioRequest body){
        Usuario usuario = mapper.map(body, Usuario.class);
        return usuarioRepo.save(usuario);
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
        Usuario usuario = mapper.map(body, Usuario.class);
        usuario.setSenha(encoder.encode(body.getSenha()));
        return usuarioRepo.save(usuario);
    }

}
