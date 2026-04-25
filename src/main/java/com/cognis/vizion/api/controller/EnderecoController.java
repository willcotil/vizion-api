package com.cognis.vizion.api.controller;

import com.cognis.vizion.api.core.endereco.Endereco;
import com.cognis.vizion.api.core.endereco.dto.EnderecoRequest;
import com.cognis.vizion.api.core.endereco.dto.EnderecoResponse;
import com.cognis.vizion.api.repository.EnderecoRepo;
import com.cognis.vizion.api.service.EnderecoService;
import com.cognis.vizion.api.service.IGenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/endereco")
public class EnderecoController extends GenericController<EnderecoRequest, EnderecoResponse, Integer>{
    public EnderecoController(EnderecoService service){super(service);}
}
