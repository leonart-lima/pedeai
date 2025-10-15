package com.leonart.pedeai.application.usecase.itemCardapio;

import com.leonart.pedeai.domain.gateway.ItemCardapioGateway;
import com.leonart.pedeai.domain.model.ItemCardapio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class ListarItensCardapioPorRestauranteUseCase {

    private final ItemCardapioGateway gateway;

    public ListarItensCardapioPorRestauranteUseCase(ItemCardapioGateway gateway) {
        this.gateway = gateway;
    }

    public List<ItemCardapio> executar(UUID restauranteId) {
        Objects.requireNonNull(restauranteId, "restauranteId é obrigatório");
        return gateway.listarPorRestaurante(restauranteId);
    }
}