package com.cognis.vizion.api.controller;

import com.cognis.vizion.api.core.obra.obraFuncionarios.dto.ObraFuncionariosRequest;
import com.cognis.vizion.api.core.obra.obraFuncionarios.dto.ObraFuncionariosResponse;
import com.cognis.vizion.api.service.ObraFuncionariosService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/obra-funcionarios")
@RequiredArgsConstructor
public class ObraFuncionariosController {

    private final ObraFuncionariosService service;

    @PostMapping
    public ResponseEntity<ObraFuncionariosResponse> create(@RequestBody ObraFuncionariosRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(request));
    }

    @GetMapping
    public ResponseEntity<List<ObraFuncionariosResponse>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ObraFuncionariosResponse> getOne(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getOne(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ObraFuncionariosResponse> update(@PathVariable Integer id, @RequestBody ObraFuncionariosRequest request) {
        return ResponseEntity.ok(service.atualizar(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
