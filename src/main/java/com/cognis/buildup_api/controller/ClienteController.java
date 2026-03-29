package com.cognis.buildup_api.controller;

import com.cognis.buildup_api.core.cliente.dto.ClienteRequest;
import com.cognis.buildup_api.core.cliente.dto.ClienteResponse;
import com.cognis.buildup_api.service.ClienteService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController extends GenericController<ClienteRequest, ClienteResponse, Integer> {
    public ClienteController(ClienteService service) {
        super(service);
    }
}
