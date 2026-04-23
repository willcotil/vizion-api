package com.cognis.vizion.api.core.obra.fasesObra.state;

import org.springframework.stereotype.Component;

@Component("fasesObraPausadaState")
public class PausadaState extends AbstractFasesObraState {
    @Override
    public FasesObraStatus getStatus() {
        return FasesObraStatus.PAUSADA;
    }

    @Override
    public FasesObraStatus transicionar(FasesObraAcao acao) {
        return switch (acao) {
            case RETOMAR -> FasesObraStatus.EM_ANDAMENTO;
            case CANCELAR -> FasesObraStatus.CANCELADA;
            default -> throw transicaoInvalida(acao);
        };
    }
}
