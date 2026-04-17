package com.cognis.vizion.api.core.obra.obraFuncionarios.dto;


import java.time.LocalDate;

public record ObraFuncionariosRequest(
        Integer id_obra,
        Integer id_funcionario,
        String tenant_id,
        String descricao_obra,
        String cargo,
        LocalDate data_inicio,
        LocalDate data_fim,
        String status
) {

}
