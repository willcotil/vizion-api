package com.cognis.vizion.api.core.obra.fasesObra.dto;


import java.util.Date;

public record FasesObraRequest(
        String nome_fase,
        Date data_inicio_estimada,
        Date data_iniciada,
        Date data_fim_estimada,
        Date data_finalizada
) {
}
