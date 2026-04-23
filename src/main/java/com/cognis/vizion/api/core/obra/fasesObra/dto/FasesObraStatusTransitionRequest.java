package com.cognis.vizion.api.core.obra.fasesObra.dto;

import jakarta.validation.constraints.NotBlank;

public record FasesObraStatusTransitionRequest(
        @NotBlank String acao
) {
}
