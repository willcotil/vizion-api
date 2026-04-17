package com.cognis.vizion.api.core.obra.obraFuncionarios.dto;


import com.cognis.vizion.api.core.obra.obraFuncionarios.ObraFuncionarios;

import java.time.LocalDate;

public record ObraFuncionariosResponse(
        Integer id,
        Integer id_obra,
        Integer id_funcionario,
        String tenant_id,
        String descricao_obra,
        String cargo,
        LocalDate data_inicio,
        LocalDate data_fim,
        String status
) {
    public ObraFuncionariosResponse(ObraFuncionarios obraFuncionarios){
        this(
                obraFuncionarios.getId(),
                obraFuncionarios.getId(),
                obraFuncionarios.getId(),
                obraFuncionarios.getTenant_id(),
                obraFuncionarios.getDescricao_obra(),
                obraFuncionarios.getCargo(),
                obraFuncionarios.getData_inicio(),
                obraFuncionarios.getData_fim(),
                obraFuncionarios.getStatus()
        );
    }
}
