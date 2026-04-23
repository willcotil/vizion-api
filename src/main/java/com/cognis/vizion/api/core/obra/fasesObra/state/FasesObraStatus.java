package com.cognis.vizion.api.core.obra.fasesObra.state;

import com.cognis.vizion.api.infra.exception.ValidationException;

public enum FasesObraStatus {
    PLANEJADA,
    EM_ANDAMENTO,
    PAUSADA,
    FINALIZADA,
    CANCELADA;

    public static FasesObraStatus from(String value) {
        if (value == null || value.isBlank()) {
            return PLANEJADA;
        }

        try {
            return FasesObraStatus.valueOf(value.trim().toUpperCase());
        } catch (IllegalArgumentException ex) {
            throw new ValidationException("Status invalido para fase de obra: " + value);
        }
    }
}

