package com.cognis.buildup_api.validator;

import com.cognis.buildup_api.core.usuario.UsuarioRequest;
import com.cognis.buildup_api.infra.exception.ValidationException;
import com.cognis.buildup_api.repository.UsuarioRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
@RequiredArgsConstructor
public class UsuarioValidator extends BaseValidator<UsuarioRequest>{

    private final UsuarioRepo repository;

    @Override
    protected void validarCampos(UsuarioRequest request) {

        String email = request.getEmail() == null
                ? ""
                : request.getEmail().trim().toLowerCase(Locale.ROOT);
        String senha = request.getSenha();


        if (email.isBlank()) {
            throw new ValidationException("Email é obrigatório");
        }

        if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            throw new ValidationException("Email inválido");
        }

        if (repository.existsByEmail(email)){
            throw new ValidationException("Email já cadastrado");
        }

        if (senha == null || senha.length() < 6) {
            throw new ValidationException("Senha deve ter no mínimo 6 caracteres");
        }
    }

}