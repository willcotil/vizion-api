package com.cognis.vizion.api.core.obra.obraArquivos.dto;

import lombok.Data;

@Data
public class ObraArquivosRequest {

    private String nome_arquivo;
    private String url_arquivo;
    private String descricao_arquivo;
}
