package com.cognis.buildup_api.controller;

import com.cognis.buildup_api.core.empreiteira.Empreiteira;
import com.cognis.buildup_api.core.empreiteira.EmpreiteiraRequest;
import com.cognis.buildup_api.core.empreiteira.EmpreiteraResponse;
import com.cognis.buildup_api.repository.EmpreiteiraRepo;
import com.cognis.buildup_api.service.EmpreiteiraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/empreiteira")
public class EmpreiteiraController extends GenericController<EmpreiteiraRequest, EmpreiteraResponse, Integer> {
    public EmpreiteiraController(EmpreiteiraService service){
        super(service);
    }
}
