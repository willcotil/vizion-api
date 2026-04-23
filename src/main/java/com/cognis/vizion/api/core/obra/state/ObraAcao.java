package com.cognis.vizion.api.core.obra.state;

import com.cognis.vizion.api.infra.exception.ValidationException;

public enum ObraAcao {
    INICIAR,
    PAUSAR,
    RETOMAR,
    FINALIZAR,
    CANCELAR;

    public static ObraAcao from(String value) {
        if (value == null || value.isBlank()) {
            throw new ValidationException("Acao de transicao obrigatoria");
        }

        try {
            return ObraAcao.valueOf(value.trim().toUpperCase());
        } catch (IllegalArgumentException ex) {
            throw new ValidationException("Acao invalida para obra: " + value);
        }
    }
}

