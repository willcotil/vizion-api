package com.cognis.vizion.api.core.obra.planta.dto;

import lombok.Data;

@Data
public class ObraPlantaRequest {
    private String nome_arquivo;
    private String url_arquivo;
    private String descricao_arquivo;
}
