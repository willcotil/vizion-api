package com.cognis.vizion.api.facade;

import com.cognis.vizion.api.core.obra.Obra;
import com.cognis.vizion.api.core.obra.state.ObraAcao;
import com.cognis.vizion.api.core.obra.state.ObraState;
import com.cognis.vizion.api.core.obra.state.ObraStateFactory;
import com.cognis.vizion.api.core.obra.state.ObraStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ObraFacade {
    private final ObraStateFactory stateFactory;

    public ObraStatus transicionarStatus(String statusAtual, ObraAcao acao) {
        ObraStatus atual = ObraStatus.from(statusAtual);
        ObraState state = stateFactory.getState(atual);
        return state.transicionar(acao);
    }

    public void transicionarStatus(Obra obra, ObraAcao acao) {
        ObraStatus novoStatus = transicionarStatus(obra.getStatus(), acao);
        obra.setStatus(novoStatus.name());
    }
}
