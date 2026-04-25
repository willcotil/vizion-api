package com.cognis.vizion.api.validator;

import org.springframework.stereotype.Component;

@Component
public abstract class BaseValidator<T>{

    public void validar(T request) {
        if (request == null) {
            throw new RuntimeException("Request não pode ser nulo");
        }

        validarCampos(request);
    }

    protected abstract void validarCampos(T request);
}