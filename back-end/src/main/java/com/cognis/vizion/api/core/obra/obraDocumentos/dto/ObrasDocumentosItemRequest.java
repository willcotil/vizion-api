package com.cognis.vizion.api.core.obra.obraDocumentos.dto;

import com.cognis.vizion.api.core.obra.obraDocumentos.TipoDocumento;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ObrasDocumentosItemRequest(
        Integer id,
        @NotNull TipoDocumento tipo_documento,
        @NotBlank String nome_arquivo,
        @NotBlank String url_arquivo,
        String descricao_arquivo
) {
}

