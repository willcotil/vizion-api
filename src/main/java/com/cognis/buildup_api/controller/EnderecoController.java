package com.cognis.buildup_api.controller;

import com.cognis.buildup_api.core.Endereco;
import com.cognis.buildup_api.repository.EnderecoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/api/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoRepo enderecoRepo;

    @PostMapping
    private Endereco criar(@RequestBody Endereco endereco){return enderecoRepo.save(endereco);}

   @GetMapping
    private ResponseEntity<Endereco> buscar(@PathVariable Integer id){
       Optional<Endereco> endereco = enderecoRepo.findById(id);
        return ResponseEntity.of(endereco);
    }

    @PutMapping
    private Endereco atualizar(@RequestBody Endereco endereco){return enderecoRepo.save(endereco);}

    @DeleteMapping
    private void deletar(@RequestBody Endereco endereco){enderecoRepo.delete(endereco);}
}
