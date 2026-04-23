package com.cognis.vizion.api.core.obra.fasesObra.state;

public interface FasesObraState {
    FasesObraStatus getStatus();

    FasesObraStatus transicionar(FasesObraAcao acao);
}

