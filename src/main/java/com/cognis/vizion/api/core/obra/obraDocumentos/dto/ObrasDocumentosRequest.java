package com.cognis.vizion.api.core.obra.obraDocumentos.dto;

import com.cognis.vizion.api.core.obra.obraDocumentos.TipoDocumento;

public record ObrasDocumentosRequest(
        Integer id_obra,
        TipoDocumento tipo_documento,
        String nome_arquivo,
        String url_arquivo,
        String descricao_arquivo
) {
}
