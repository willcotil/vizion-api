package com.cognis.vizion.api.core.obra.fasesObra.state;

import org.springframework.stereotype.Component;

@Component("fasesObraEmAndamentoState")
public class EmAndamentoState extends AbstractFasesObraState {
    @Override
    public FasesObraStatus getStatus() {
        return FasesObraStatus.EM_ANDAMENTO;
    }

    @Override
    public FasesObraStatus transicionar(FasesObraAcao acao) {
        return switch (acao) {
            case PAUSAR -> FasesObraStatus.PAUSADA;
            case FINALIZAR -> FasesObraStatus.FINALIZADA;
            case CANCELAR -> FasesObraStatus.CANCELADA;
            default -> throw transicaoInvalida(acao);
        };
    }
}
