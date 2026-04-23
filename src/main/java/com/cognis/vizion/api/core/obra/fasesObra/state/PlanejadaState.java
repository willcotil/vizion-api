package com.cognis.vizion.api.core.obra.fasesObra.state;

import org.springframework.stereotype.Component;

@Component
public class PlanejadaState extends AbstractFasesObraState {
    @Override
    public FasesObraStatus getStatus() {
        return FasesObraStatus.PLANEJADA;
    }

    @Override
    public FasesObraStatus transicionar(FasesObraAcao acao) {
        return switch (acao) {
            case INICIAR -> FasesObraStatus.EM_ANDAMENTO;
            case CANCELAR -> FasesObraStatus.CANCELADA;
            default -> throw transicaoInvalida(acao);
        };
    }
}

