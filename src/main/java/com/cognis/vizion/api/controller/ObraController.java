package com.cognis.vizion.api.controller;

import com.cognis.vizion.api.core.obra.dto.ObraRequest;
import com.cognis.vizion.api.core.obra.dto.ObraResponse;
import com.cognis.vizion.api.core.obra.dto.ObraStatusTransitionRequest;
import com.cognis.vizion.api.service.ObraService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
