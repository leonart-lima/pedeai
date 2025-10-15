package com.leonart.pedeai.application.usecase.itemCardapio;

import com.leonart.pedeai.domain.gateway.ItemCardapioGateway;
import com.leonart.pedeai.domain.model.ItemCardapio;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.UUID;

@Service
public class BuscarItemCardapioPorIdUseCase {

    private final ItemCardapioGateway gateway;

    public BuscarItemCardapioPorIdUseCase(ItemCardapioGateway gateway) {
        this.gateway = gateway;
    }

    public ItemCardapio executar(UUID id) {
        Objects.requireNonNull(id, "id é obrigatório");
        return gateway.buscarPorId(id)
                .orElseThrow(() -> new NoSuchElementException("Item de cardápio não encontrado"));
    }
}