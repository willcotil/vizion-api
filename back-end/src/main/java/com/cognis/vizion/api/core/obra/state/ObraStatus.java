package com.cognis.vizion.api.core.obra.state;

import com.cognis.vizion.api.infra.exception.ValidationException;

public enum ObraStatus {
    PLANEJADA,
    EM_ANDAMENTO,
    PAUSADA,
    FINALIZADA,
    CANCELADA;

    public static ObraStatus from(String value) {
        if (value == null || value.isBlank()) {
            return PLANEJADA;
        }

        try {
            return ObraStatus.valueOf(value.trim().toUpperCase());
        } catch (IllegalArgumentException ex) {
            throw new ValidationException("Status invalido para obra: " + value);
        }
    }
}

