package com.cognis.vizion.api.core.obra.obraPlanta.dto;


public record ObraPlantaRequest(
        String nome_arquivo,
        String url_arquivo,
        String descricao_arquivo
) {
}
