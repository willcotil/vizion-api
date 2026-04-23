package com.cognis.vizion.api.core.obra.state;

import org.springframework.stereotype.Component;

@Component("obraPlanejadaState")
public class PlanejadaState extends AbstractObraState {
    @Override
    public ObraStatus getStatus() {
        return ObraStatus.PLANEJADA;
    }

    @Override
    public ObraStatus transicionar(ObraAcao acao) {
        return switch (acao) {
            case INICIAR -> ObraStatus.EM_ANDAMENTO;
            case CANCELAR -> ObraStatus.CANCELADA;
            default -> throw transicaoInvalida(acao);
        };
    }
}
