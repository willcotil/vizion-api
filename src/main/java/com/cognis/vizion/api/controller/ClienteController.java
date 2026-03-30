package com.cognis.vizion.api.controller;

import com.cognis.vizion.api.core.cliente.dto.ClienteRequest;
import com.cognis.vizion.api.core.cliente.dto.ClienteResponse;
import com.cognis.vizion.api.service.ClienteService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController extends GenericController<ClienteRequest, ClienteResponse, Integer> {
    public ClienteController(ClienteService service) {
        super(service);
    }
}
