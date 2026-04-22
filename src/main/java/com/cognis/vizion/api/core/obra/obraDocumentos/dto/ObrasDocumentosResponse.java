package com.cognis.vizion.api.core.obra.obraDocumentos.dto;

import com.cognis.vizion.api.core.obra.obraDocumentos.ObrasDocumentos;
import com.cognis.vizion.api.core.obra.obraDocumentos.TipoDocumento;

public record ObrasDocumentosResponse(
        Integer id,
        Integer id_obra,
        TipoDocumento tipo_documento,
        String nome_arquivo,
        String url_arquivo,
        String descricao_arquivo
) {
    public ObrasDocumentosResponse(ObrasDocumentos obrasDocumentos) {
        this(
                obrasDocumentos.getId(),
                obrasDocumentos.getObra().getId(),
                obrasDocumentos.getTipo_documento(),
                obrasDocumentos.getNome_arquivo(),
                obrasDocumentos.getUrl_arquivo(),
                obrasDocumentos.getDescricao_arquivo()
        );
    }
}
