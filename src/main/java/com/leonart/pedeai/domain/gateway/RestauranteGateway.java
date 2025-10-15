package com.leonart.pedeai.domain.gateway;

import com.leonart.pedeai.domain.model.Restaurante;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RestauranteGateway {
    Restaurante salvar(Restaurante restaurante);
    Optional<Restaurante> buscarPorId(UUID id);
    List<Restaurante> listarTodos();
    void deletar(UUID id);
}
