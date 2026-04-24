package com.cognis.vizion.api.controller;

import com.cognis.vizion.api.core.obra.fasesObra.dto.FasesObraRequest;
import com.cognis.vizion.api.core.obra.fasesObra.dto.FasesObraResponse;
import com.cognis.vizion.api.core.obra.fasesObra.dto.FasesObraStatusTransitionRequest;
import com.cognis.vizion.api.service.FasesObraService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/fasesObra")
public class FasesObraController extends GenericController<FasesObraRequest, FasesObraResponse, Integer>{

    public FasesObraController(FasesObraService fasesObraService){
        super(fasesObraService);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<FasesObraResponse> transicionarStatus(
            @PathVariable Integer id,
            @RequestBody @Valid FasesObraStatusTransitionRequest request
    ) {
        return ResponseEntity.ok(((FasesObraService) service).transicionarStatus(id, request));
    }
}
