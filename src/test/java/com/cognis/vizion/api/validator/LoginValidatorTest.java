package com.cognis.vizion.api.validator;

import com.cognis.vizion.api.core.auth.dto.LoginRequest;
import com.cognis.vizion.api.infra.exception.ValidationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginValidatorTest {

    private final LoginValidator validator = new LoginValidator();

    @Test
    @DisplayName("Deve validar login com sucesso")
    void validarSucesso() {
        var request = new LoginRequest("user@email.com", "123456");
        assertDoesNotThrow(() -> validator.validarCampos(request));
    }

    @Test
    @DisplayName("Deve falhar quando e-mail for inválido")
    void validarEmailInvalido() {
        var request = new LoginRequest("email_sem_arroba", "123456");

        var exception = assertThrows(ValidationException.class, () ->
                validator.validarCampos(request)
        );
        assertEquals("Email inválido", exception.getMessage());
    }

    @Test
    @DisplayName("Deve falhar quando e-mail estiver em branco")
    void validarEmailVazio() {
        var request = new LoginRequest("   ", "123456");

        var exception = assertThrows(ValidationException.class, () ->
                validator.validarCampos(request)
        );
        assertEquals("Email é obrigatório", exception.getMessage());
    }

    @Test
    @DisplayName("Deve falhar quando senha estiver em branco")
    void validarSenhaVazia() {
        var request = new LoginRequest("user@email.com", "");

        var exception = assertThrows(ValidationException.class, () ->
                validator.validarCampos(request)
        );
        assertEquals("Senha é obrigatória", exception.getMessage());
    }
}