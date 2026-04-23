package com.cognis.vizion.api.core.obra.state;

import org.springframework.stereotype.Component;

@Component("obraEmAndamentoState")
public class EmAndamentoState extends AbstractObraState {
    @Override
    public ObraStatus getStatus() {
        return ObraStatus.EM_ANDAMENTO;
    }

    @Override
    public ObraStatus transicionar(ObraAcao acao) {
        return switch (acao) {
            case PAUSAR -> ObraStatus.PAUSADA;
            case FINALIZAR -> ObraStatus.FINALIZADA;
            case CANCELAR -> ObraStatus.CANCELADA;
            default -> throw transicaoInvalida(acao);
        };
    }
}
