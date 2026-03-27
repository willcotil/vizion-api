package com.cognis.buildup_api.core.obra.fases_obra;

import lombok.Data;

import java.util.Date;

@Data
public class FasesObraRequest {

    private String nome_fase;
    private Date data_inicio_estimada;
    private Date data_iniciada;
    private Date data_fim_estimada;
    private Date data_finalizada;
}
