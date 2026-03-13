package com.cognis.buildup_api.controller;

import com.cognis.buildup_api.repository.EnderecoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoRepo enderecoRepo;


}
