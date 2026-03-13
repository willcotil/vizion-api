package com.cognis.buildup_api.controller;

import com.cognis.buildup_api.core.Empreiteira;
import com.cognis.buildup_api.repository.EmpreiteiraRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/empreiteira")
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
}
