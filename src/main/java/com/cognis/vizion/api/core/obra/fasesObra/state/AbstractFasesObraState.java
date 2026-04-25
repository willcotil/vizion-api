package com.cognis.vizion.api.core.obra.fasesObra.state;

import com.cognis.vizion.api.infra.exception.ValidationException;

public abstract class AbstractFasesObraState implements FasesObraState {
    protected ValidationException transicaoInvalida(FasesObraAcao acao) {
        return new ValidationException("Nao e permitido executar a acao " + acao + " quando a fase esta em " + getStatus());
    }
}

