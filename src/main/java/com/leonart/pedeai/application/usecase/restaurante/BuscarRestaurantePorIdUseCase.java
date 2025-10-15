package com.leonart.pedeai.application.usecase.restaurante;

import com.leonart.pedeai.domain.gateway.RestauranteGateway;
import com.leonart.pedeai.domain.model.Restaurante;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.UUID;

@Service
public class BuscarRestaurantePorIdUseCase {

    private final RestauranteGateway gateway;

    public BuscarRestaurantePorIdUseCase(RestauranteGateway gateway) {
        this.gateway = gateway;
    }

    public Restaurante executar(UUID id) {
        Objects.requireNonNull(id, "id é obrigatório");
        return gateway.buscarPorId(id)
                .orElseThrow(() -> new NoSuchElementException("Restaurante não encontrado"));
    }
}