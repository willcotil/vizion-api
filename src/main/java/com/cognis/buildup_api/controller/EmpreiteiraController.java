package com.cognis.buildup_api.controller;

import com.cognis.buildup_api.core.empreiteira.dto.EmpreiteiraRequest;
import com.cognis.buildup_api.core.empreiteira.dto.EmpreiteraResponse;
import com.cognis.buildup_api.service.EmpreiteiraService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/empreiteira")
public class EmpreiteiraController extends GenericController<EmpreiteiraRequest, EmpreiteraResponse, Integer> {
    public EmpreiteiraController(EmpreiteiraService service){
        super(service);
    }
}
