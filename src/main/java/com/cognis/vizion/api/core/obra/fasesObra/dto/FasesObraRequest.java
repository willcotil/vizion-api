package com.cognis.vizion.api.core.obra.fasesObra.dto;

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
