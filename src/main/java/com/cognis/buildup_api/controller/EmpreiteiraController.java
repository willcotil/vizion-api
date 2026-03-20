package com.cognis.buildup_api.controller;

import com.cognis.buildup_api.core.empreiteira.Empreiteira;
import com.cognis.buildup_api.repository.EmpreiteiraRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/empreiteira")
public class EmpreiteiraController {

    @Autowired
    private EmpreiteiraRepo empreiteiraRepo;


    @PutMapping
    public Empreiteira atualizar(@RequestBody Empreiteira body){
        return empreiteiraRepo.save(body);
    }

    @DeleteMapping
    public void deletar(@RequestBody Empreiteira body){
        empreiteiraRepo.delete(body);
    }

    @GetMapping
    public ResponseEntity<Empreiteira> buscarPorId(@RequestBody Integer id){
        Optional<Empreiteira> buscarPorId = empreiteiraRepo.findById(id);
        return ResponseEntity.of(buscarPorId);
    }

    @PostMapping
    public Empreiteira inserirDados(@RequestBody Empreiteira body){
        return empreiteiraRepo.save(body);
    }

}
