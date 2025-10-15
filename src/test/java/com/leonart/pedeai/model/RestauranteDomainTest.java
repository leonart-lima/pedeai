package com.leonart.pedeai.model;

import com.leonart.pedeai.domain.model.Restaurante;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.*;

class RestauranteDomainTest {

    @Test
    void deveCriarRestauranteValido() {
        UUID id = UUID.randomUUID();
        Restaurante restaurante = new Restaurante(id, "Pizzaria", "pizzaria@email.com");

        assertThat(restaurante.getId()).isEqualTo(id);
        assertThat(restaurante.getNome()).isEqualTo("Pizzaria");
        assertThat(restaurante.getEmail()).isEqualTo("pizzaria@email.com");
    }

    @Test
    void deveGerarIdSeNaoInformado() {
        Restaurante restaurante = new Restaurante(null, "Pizzaria", "pizzaria@email.com");
        assertThat(restaurante.getId()).isNotNull();
    }

    @Test
    void deveLancarExcecaoSeNomeNuloOuVazio() {
        assertThatThrownBy(() -> new Restaurante(UUID.randomUUID(), null, "pizzaria@email.com"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("nome é obrigatório");

        assertThatThrownBy(() -> new Restaurante(UUID.randomUUID(), "   ", "pizzaria@email.com"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("nome é obrigatório");
    }

    @Test
    void deveLancarExcecaoSeEmailNuloOuVazio() {
        assertThatThrownBy(() -> new Restaurante(UUID.randomUUID(), "Pizzaria", null))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("email é obrigatório");

        assertThatThrownBy(() -> new Restaurante(UUID.randomUUID(), "Pizzaria", "   "))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("email é obrigatório");
    }

    @Test
    void deveNormalizarNomeEEmail() {
        Restaurante restaurante = new Restaurante(UUID.randomUUID(), "  Pizzaria  ", "  PIZZA@EMAIL.COM  ");
        assertThat(restaurante.getNome()).isEqualTo("Pizzaria");
        assertThat(restaurante.getEmail()).isEqualTo("pizza@email.com");
    }

    @Test
    void restaurantesComMesmoIdSaoIguais() {
        UUID id = UUID.randomUUID();
        Restaurante r1 = new Restaurante(id, "A", "a@email.com");
        Restaurante r2 = new Restaurante(id, "B", "b@email.com");

        assertThat(r1).isEqualTo(r2);
        assertThat(r1.hashCode()).isEqualTo(r2.hashCode());
    }
}