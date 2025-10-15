package com.leonart.pedeai.model;

import com.leonart.pedeai.domain.model.Usuario;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class UsuarioDomainTest {

    private static Validator validator;

    @BeforeAll
    static void setupValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void deveValidarUsuarioValido() {
        Usuario usuario = new Usuario();
        usuario.setNome("Leonardo");
        usuario.setEmail("leo@email.com");

        Set<ConstraintViolation<Usuario>> violations = validator.validate(usuario);
        assertThat(violations).isEmpty();
    }

    @Test
    void deveDetectarEmailInvalido() {
        Usuario usuario = new Usuario();
        usuario.setNome("Leonardo");
        usuario.setEmail("email-invalido");

        Set<ConstraintViolation<Usuario>> violations = validator.validate(usuario);
        assertThat(violations).anyMatch(v -> v.getPropertyPath().toString().equals("email"));
    }

    @Test
    void deveDetectarNomeObrigatorio() {
        Usuario usuario = new Usuario();
        usuario.setNome(null);
        usuario.setEmail("leo@email.com");

        Set<ConstraintViolation<Usuario>> violations = validator.validate(usuario);
        assertThat(violations).anyMatch(v -> v.getPropertyPath().toString().equals("nome"));
    }
}