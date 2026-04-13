package com.cognis.vizion.api.controller;

import com.cognis.vizion.api.core.obra.obraEmpreiteiro.dto.ObraEmpreiteiroRequest;
import com.cognis.vizion.api.core.obra.obraEmpreiteiro.dto.ObraEmpreiteiroResponse;
import com.cognis.vizion.api.service.ObraEmpreiteiroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/obra-empreiteiro")
@RequiredArgsConstructor
public class ObraEmpreiteiroController {

    private final ObraEmpreiteiroService service;

    @PostMapping
    public ResponseEntity<ObraEmpreiteiroResponse> create(@RequestBody ObraEmpreiteiroRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(request));
    }

    @GetMapping
    public ResponseEntity<List<ObraEmpreiteiroResponse>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ObraEmpreiteiroResponse> getOne(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getOne(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ObraEmpreiteiroResponse> update(@PathVariable Integer id, @RequestBody ObraEmpreiteiroRequest request) {
        return ResponseEntity.ok(service.atualizar(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
