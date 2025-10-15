package com.leonart.pedeai.application.usecase.itemCardapio;

import com.leonart.pedeai.domain.gateway.ItemCardapioGateway;
import com.leonart.pedeai.domain.model.ItemCardapio;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.UUID;

@Service
public class AtualizarItemCardapioUseCase {

    private final ItemCardapioGateway gateway;

    public AtualizarItemCardapioUseCase(ItemCardapioGateway gateway) {
        this.gateway = gateway;
    }

    public ItemCardapio executar(UUID id, ItemCardapio dadosAtualizados) {
        Objects.requireNonNull(id, "id é obrigatório");
        Objects.requireNonNull(dadosAtualizados, "dadosAtualizados é obrigatório");

        ItemCardapio existente = gateway.buscarPorId(id)
                .orElseThrow(() -> new NoSuchElementException("Item de cardápio não encontrado"));

        // Aplique aqui o merge dos campos conforme seu domínio:
        // exemplo:
        // existente.setNome(dadosAtualizados.getNome());
        // existente.setPreco(dadosAtualizados.getPreco());
        // existente.setDescricao(dadosAtualizados.getDescricao());
        // ...

        return gateway.salvar(existente);
    }
}