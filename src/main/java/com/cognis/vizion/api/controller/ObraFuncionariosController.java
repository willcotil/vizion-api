package com.cognis.vizion.api.controller;

import com.cognis.vizion.api.core.obra.obraFuncionarios.ObraFuncionarios;
import com.cognis.vizion.api.core.obra.obraFuncionarios.dto.ObraFuncionariosRequest;
import com.cognis.vizion.api.core.obra.obraFuncionarios.dto.ObraFuncionariosResponse;
import com.cognis.vizion.api.service.ObraArquivosService;
import com.cognis.vizion.api.service.ObraFuncionariosService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/obra-funcionarios")
public class ObraFuncionariosController extends GenericController<ObraFuncionariosRequest, ObraFuncionariosResponse, Integer>{

    public ObraFuncionariosController(ObraFuncionariosService obraFuncionariosService){
        super(obraFuncionariosService);
    }
}
