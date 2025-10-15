package com.leonart.pedeai.application.usecase.itemCardapio;

import com.leonart.pedeai.domain.gateway.ItemCardapioGateway;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.UUID;

@Service
public class DeletarItemCardapioUseCase {

    private final ItemCardapioGateway gateway;

    public DeletarItemCardapioUseCase(ItemCardapioGateway gateway) {
        this.gateway = gateway;
    }

    public void executar(UUID id) {
        Objects.requireNonNull(id, "id é obrigatório");
        boolean existe = gateway.buscarPorId(id).isPresent();
        if (!existe) {
            throw new NoSuchElementException("Item de cardápio não encontrado");
        }
        gateway.deletar(id);
    }
}