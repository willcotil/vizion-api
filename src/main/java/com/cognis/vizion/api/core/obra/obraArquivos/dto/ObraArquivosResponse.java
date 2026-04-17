package com.cognis.vizion.api.core.obra.obraArquivos.dto;


import com.cognis.vizion.api.core.obra.obraArquivos.ObraArquivos;

public record ObraArquivosResponse (
        String nome_arquivo,
        String url_arquivo,
        String descricao_arquivo
) {
    public ObraArquivosResponse(ObraArquivos obraArquivos){
        this(
                obraArquivos.getNome_arquivo(),
                obraArquivos.getUrl_arquivo(),
                obraArquivos.getDescricao_arquivo()
        );
    }
}
