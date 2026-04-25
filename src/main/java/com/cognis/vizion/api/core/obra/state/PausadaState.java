package com.cognis.vizion.api.core.obra.state;

import org.springframework.stereotype.Component;

@Component("obraPausadaState")
public class PausadaState extends AbstractObraState {
    @Override
    public ObraStatus getStatus() {
        return ObraStatus.PAUSADA;
    }

    @Override
    public ObraStatus transicionar(ObraAcao acao) {
        return switch (acao) {
            case RETOMAR -> ObraStatus.EM_ANDAMENTO;
            case CANCELAR -> ObraStatus.CANCELADA;
            default -> throw transicaoInvalida(acao);
        };
    }
}
