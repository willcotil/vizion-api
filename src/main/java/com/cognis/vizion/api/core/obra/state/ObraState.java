package com.cognis.vizion.api.core.obra.state;

public interface ObraState {
    ObraStatus getStatus();

    ObraStatus transicionar(ObraAcao acao);
}

