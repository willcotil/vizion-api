package com.cognis.vizion.api.core.obra.state;

import com.cognis.vizion.api.infra.exception.ValidationException;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@Component
public class ObraStateFactory {
    private final Map<ObraStatus, ObraState> stateByStatus = new EnumMap<>(ObraStatus.class);

    public ObraStateFactory(List<ObraState> states) {
        for (ObraState state : states) {
            stateByStatus.put(state.getStatus(), state);
        }
    }

    public ObraState getState(ObraStatus status) {
        ObraState state = stateByStatus.get(status);

        if (state == null) {
            throw new ValidationException("Nao existe implementacao de state para o status " + status);
        }

        return state;
    }
}

