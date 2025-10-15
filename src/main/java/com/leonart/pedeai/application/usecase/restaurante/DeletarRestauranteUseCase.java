package com.leonart.pedeai.application.usecase.restaurante;

import com.leonart.pedeai.domain.gateway.RestauranteGateway;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.UUID;

@Service
public class DeletarRestauranteUseCase {

    private final RestauranteGateway gateway;

    public DeletarRestauranteUseCase(RestauranteGateway gateway) {
        this.gateway = gateway;
    }

    public void executar(UUID id) {
        Objects.requireNonNull(id, "id é obrigatório");
        if (gateway.buscarPorId(id).isEmpty()) {
            throw new NoSuchElementException("Restaurante não encontrado");
        }
        gateway.deletar(id);
    }
}