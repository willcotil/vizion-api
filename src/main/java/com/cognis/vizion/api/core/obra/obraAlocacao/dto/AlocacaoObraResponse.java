package com.cognis.vizion.api.core.obra.obraAlocacao.dto;

import com.cognis.vizion.api.core.obra.obraAlocacao.ObraAlocacaoEquipe;

import java.time.LocalDate;

public record AlocacaoObraResponse(
        Integer id,
        Integer id_obra,
        Integer id_usuario,
        String role_obra,
        LocalDate data_inicio
) {
    public AlocacaoObraResponse(ObraAlocacaoEquipe obraAlocacaoEquipe){
        this(
                obraAlocacaoEquipe.getId(),
                obraAlocacaoEquipe.getId_obra(),
                obraAlocacaoEquipe.getId_usuario(),
                obraAlocacaoEquipe.getRole_obra(),
                obraAlocacaoEquipe.getData_inicio()
        );
    }
}