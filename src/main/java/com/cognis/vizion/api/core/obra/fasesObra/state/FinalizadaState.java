package com.cognis.vizion.api.core.obra.fasesObra.state;

import org.springframework.stereotype.Component;

@Component
public class FinalizadaState extends AbstractFasesObraState {
    @Override
    public FasesObraStatus getStatus() {
        return FasesObraStatus.FINALIZADA;
    }

    @Override
    public FasesObraStatus transicionar(FasesObraAcao acao) {
        throw transicaoInvalida(acao);
    }
}

