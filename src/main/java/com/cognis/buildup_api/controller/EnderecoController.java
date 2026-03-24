package com.cognis.buildup_api.controller;

import com.cognis.buildup_api.core.endereco.Endereco;
import com.cognis.buildup_api.repository.EnderecoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoRepo enderecoRepo;

    @PostMapping
    private Endereco criar(@RequestBody Endereco body){return enderecoRepo.save(body);}

   @GetMapping
    private ResponseEntity<Endereco> buscarPorId(@PathVariable Integer id){
       Optional<Endereco> buscarPorId = enderecoRepo.findById(id);
        return ResponseEntity.of(buscarPorId);
    }

    @PutMapping
    private Endereco atualizar(@RequestBody Endereco endereco){return enderecoRepo.save(endereco);}

    @DeleteMapping
    private void deletar(@RequestBody Endereco endereco){enderecoRepo.delete(endereco);}
}
