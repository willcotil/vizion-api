package com.cognis.vizion.api.controller;

import com.cognis.vizion.api.core.obra.dto.ObraAggregateRequest;
import com.cognis.vizion.api.core.obra.dto.ObraDetailResponse;
import com.cognis.vizion.api.core.obra.dto.ObraRequest;
import com.cognis.vizion.api.core.obra.dto.ObraResponse;
import com.cognis.vizion.api.core.obra.dto.ObraStatusTransitionRequest;
import com.cognis.vizion.api.core.usuario.Usuario;
import com.cognis.vizion.api.service.ObraService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<ObraDetailResponse> salvarAggregate(
            @RequestBody @Valid ObraAggregateRequest request,
            @AuthenticationPrincipal Usuario user
    ) {
        return ResponseEntity.ok(obraService.salvarOuAtualizarAggregate(request, null, user));
    }

    @PutMapping("/{id}/aggregate")
    public ResponseEntity<ObraDetailResponse> atualizarAggregate(
            @PathVariable Integer id,
            @RequestBody @Valid ObraAggregateRequest request,
            @AuthenticationPrincipal Usuario user
    ) {
        return ResponseEntity.ok(obraService.salvarOuAtualizarAggregate(request, id, user));
    }

    @GetMapping("/minhas-obras")
    public ResponseEntity<List<ObraResponse>> getMinhasObras(
            @AuthenticationPrincipal Usuario user
    ) {
        return ResponseEntity.ok(obraService.listarMinhasObras(user));
    }
}
