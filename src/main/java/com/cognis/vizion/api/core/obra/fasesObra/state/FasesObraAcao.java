package com.cognis.vizion.api.core.obra.fasesObra.state;

import com.cognis.vizion.api.infra.exception.ValidationException;

public enum FasesObraAcao {
    INICIAR,
    PAUSAR,
    RETOMAR,
    FINALIZAR,
    CANCELAR;

    public static FasesObraAcao from(String value) {
        if (value == null || value.isBlank()) {
            throw new ValidationException("Acao de transicao obrigatoria");
        }

        try {
            return FasesObraAcao.valueOf(value.trim().toUpperCase());
        } catch (IllegalArgumentException ex) {
            throw new ValidationException("Acao invalida para fase de obra: " + value);
        }
    }
}

