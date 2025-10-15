package com.leonart.pedeai.application.usecase.restaurante;

import com.leonart.pedeai.domain.gateway.RestauranteGateway;
import com.leonart.pedeai.domain.model.Restaurante;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.UUID;

@Service
public class AtualizarRestauranteUseCase {

    private final RestauranteGateway gateway;

    public AtualizarRestauranteUseCase(RestauranteGateway gateway) {
        this.gateway = gateway;
    }

    public Restaurante executar(UUID id, Restaurante dadosAtualizados) {
        Objects.requireNonNull(id, "id é obrigatório");
        Objects.requireNonNull(dadosAtualizados, "dadosAtualizados é obrigatório");

        Restaurante existente = gateway.buscarPorId(id)
                .orElseThrow(() -> new NoSuchElementException("Restaurante não encontrado"));

        // Aplique aqui o merge dos campos conforme seu domínio:
        // existente.setNome(dadosAtualizados.getNome());
        // existente.setDescricao(dadosAtualizados.getDescricao());
        // existente.setCnpj(dadosAtualizados.getCnpj());
        // existente.setEndereco(dadosAtualizados.getEndereco());
        // ...

        return gateway.salvar(existente);
    }
}