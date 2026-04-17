package com.cognis.vizion.api.core.obra.obraArquivos.dto;

public record ObraArquivosRequest(
        String nome_arquivo,
        String url_arquivo,
        String descricao_arquivo
) {
}
