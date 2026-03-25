package com.cognis.buildup_api.controller;

import com.cognis.buildup_api.core.cliente.Cliente;
import com.cognis.buildup_api.core.cliente.ClienteRequest;
import com.cognis.buildup_api.core.cliente.ClienteResponse;
import com.cognis.buildup_api.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController extends GenericController<ClienteRequest, ClienteResponse, Integer> {
    public ClienteController(ClienteService service) {
        super(service);
    }
}
