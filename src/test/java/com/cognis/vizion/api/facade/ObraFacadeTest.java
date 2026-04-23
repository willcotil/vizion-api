package com.cognis.vizion.api.facade;

import com.cognis.vizion.api.core.obra.Obra;
import com.cognis.vizion.api.core.obra.state.*;
import com.cognis.vizion.api.infra.exception.ValidationException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ObraFacadeTest {

    private ObraFacade buildFacade() {
        ObraStateFactory factory = new ObraStateFactory(List.of(
                new PlanejadaState(),
                new EmAndamentoState(),
                new PausadaState(),
                new FinalizadaState(),
                new CanceladaState()
        ));

        return new ObraFacade(factory);
    }

    @Test
    void deveIniciarObraPlanejada() {
        ObraFacade facade = buildFacade();

        ObraStatus novoStatus = facade.transicionarStatus("PLANEJADA", ObraAcao.INICIAR);

        assertEquals(ObraStatus.EM_ANDAMENTO, novoStatus);
    }

    @Test
    void deveFalharAoRetomarObraPlanejada() {
        ObraFacade facade = buildFacade();

        assertThrows(ValidationException.class,
                () -> facade.transicionarStatus("PLANEJADA", ObraAcao.RETOMAR));
    }

    @Test
    void deveAtualizarStatusDaObra() {
        ObraFacade facade = buildFacade();
        Obra obra = new Obra();
        obra.setStatus("PAUSADA");

        facade.transicionarStatus(obra, ObraAcao.RETOMAR);

        assertEquals("EM_ANDAMENTO", obra.getStatus());
    }
}
