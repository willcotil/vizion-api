package com.cognis.vizion.api.core.obra.obraAlocacao.dto;

import java.time.LocalDate;

public record AlocacaoObraRequest(
        Integer id_obra,
        Integer id_usuario,
        String role_obra,
        LocalDate data_inicio
) {
}