package com.cognis.vizion.api.core.obra.state;

import com.cognis.vizion.api.infra.exception.ValidationException;

public abstract class AbstractObraState implements ObraState {
    protected ValidationException transicaoInvalida(ObraAcao acao) {
        return new ValidationException("Nao e permitido executar acao " + acao + " quando a obra esta em " + getStatus());
    }
}

