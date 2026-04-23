package com.cognis.vizion.api.core.obra.fasesObra.state;

import org.springframework.stereotype.Component;

@Component
public class CanceladaState extends AbstractFasesObraState {
    @Override
    public FasesObraStatus getStatus() {
        return FasesObraStatus.CANCELADA;
    }

    @Override
    public FasesObraStatus transicionar(FasesObraAcao acao) {
        throw transicaoInvalida(acao);
    }
}

