package com.cognis.vizion.api.core.obra.state;

import org.springframework.stereotype.Component;

@Component
public class FinalizadaState extends AbstractObraState {
    @Override
    public ObraStatus getStatus() {
        return ObraStatus.FINALIZADA;
    }

    @Override
    public ObraStatus transicionar(ObraAcao acao) {
        throw transicaoInvalida(acao);
    }
}

