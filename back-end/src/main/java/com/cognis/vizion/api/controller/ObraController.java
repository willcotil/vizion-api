package com.cognis.vizion.api.controller;

import com.cognis.vizion.api.core.obra.dto.ObraAggregateRequest;
import com.cognis.vizion.api.core.obra.dto.ObraDetailResponse;
import com.cognis.vizion.api.core.obra.dto.ObraRequest;
import com.cognis.vizion.api.core.obra.dto.ObraResponse;
import com.cognis.vizion.api.core.obra.dto.ObraStatusTransitionRequest;
import com.cognis.vizion.api.service.ObraService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/obra")
public class ObraController extends GenericController<ObraRequest, ObraResponse, Integer>{
    private final ObraService obraService;

    public ObraController(ObraService obraService){
        super(obraService);
        this.obraService = obraService;
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<ObraResponse> transicionarStatus(
            @PathVariable Integer id,
            @RequestBody @Valid ObraStatusTransitionRequest request
    ) {
        return ResponseEntity.ok(obraService.transicionarStatus(id, request));
    }

    @PostMapping("/aggregate")
    public ResponseEntity<ObraDetailResponse> salvarAggregate(@RequestBody @Valid ObraAggregateRequest request) {
        return ResponseEntity.ok(obraService.salvarAggregate(request));
    }

    @PutMapping("/{id}/aggregate")
    public ResponseEntity<ObraDetailResponse> atualizarAggregate(
            @PathVariable Integer id,
            @RequestBody @Valid ObraAggregateRequest request
    ) {
        return ResponseEntity.ok(obraService.atualizarAggregate(id, request));
    }
}
