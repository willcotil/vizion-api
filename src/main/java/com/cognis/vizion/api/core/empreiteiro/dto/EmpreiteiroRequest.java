package com.cognis.vizion.api.core.empreiteiro.dto;

import com.cognis.vizion.api.core.usuario.UsuarioRequest;
import lombok.Data;

@Data
public class EmpreiteiroRequest{

    private String name;

    private String documento;

    private String telefone;

    private UsuarioRequest usuario;

}
