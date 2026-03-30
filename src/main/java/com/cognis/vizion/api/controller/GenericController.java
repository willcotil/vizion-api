package com.cognis.vizion.api.controller;

import com.cognis.vizion.api.service.IGenericService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class  GenericController<REQ, RES, ID> {

    protected final IGenericService<REQ, RES, ID> service;

    protected GenericController(IGenericService<REQ, RES, ID> service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<RES> save(@Valid @RequestBody REQ request) {
        return ResponseEntity.ok(service.salvar(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RES> update(@RequestBody REQ request, @PathVariable ID id) {
        return ResponseEntity.ok(service.atualizar(request, id));
    }

    @GetMapping
    public ResponseEntity<List<RES>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RES> getOne(@PathVariable ID id) {
        return ResponseEntity.ok(service.getOne(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOne(@PathVariable ID id) {
        service.deleteOne(id);
        return ResponseEntity.ok("Deletado Com Sucesso");
    }
}