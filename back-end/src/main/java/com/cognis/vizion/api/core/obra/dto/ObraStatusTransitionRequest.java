package com.cognis.vizion.api.core.obra.dto;

import jakarta.validation.constraints.NotBlank;

public record ObraStatusTransitionRequest(
        @NotBlank String acao
) {
}
