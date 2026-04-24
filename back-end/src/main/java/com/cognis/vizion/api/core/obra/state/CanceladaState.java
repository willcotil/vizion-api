package com.cognis.vizion.api.core.obra.state;

import org.springframework.stereotype.Component;

@Component("obraCanceladaState")
public class CanceladaState extends AbstractObraState {
    @Override
    public ObraStatus getStatus() {
        return ObraStatus.CANCELADA;
    }

    @Override
    public ObraStatus transicionar(ObraAcao acao) {
        throw transicaoInvalida(acao);
    }
}
