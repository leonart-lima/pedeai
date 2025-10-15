package com.leonart.pedeai.domain.gateway;

import com.leonart.pedeai.domain.model.ItemCardapio;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ItemCardapioGateway {
    ItemCardapio salvar(ItemCardapio item);
    Optional<ItemCardapio> buscarPorId(UUID id);
    List<ItemCardapio> listarPorRestaurante(UUID restauranteId);
    void deletar(UUID id);
}
