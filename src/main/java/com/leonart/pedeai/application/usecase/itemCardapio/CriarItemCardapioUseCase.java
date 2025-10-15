package com.leonart.pedeai.application.usecase.itemCardapio;

import com.leonart.pedeai.application.dto.request.CriarItemCardapioRequest;
import com.leonart.pedeai.domain.exception.RestauranteNaoEncontradoException;
import com.leonart.pedeai.domain.exception.UsuarioNaoEncontradoException;
import com.leonart.pedeai.domain.gateway.ItemCardapioGateway;
import com.leonart.pedeai.domain.gateway.RestauranteGateway;
import com.leonart.pedeai.domain.model.ItemCardapio;
import com.leonart.pedeai.domain.model.Restaurante;
import com.leonart.pedeai.domain.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CriarItemCardapioUseCase {

    private final ItemCardapioGateway gateway;
    private final RestauranteGateway restauranteGateway;

    public CriarItemCardapioUseCase(ItemCardapioGateway gateway, RestauranteGateway restauranteGateway) {
        this.gateway = gateway;
        this.restauranteGateway = restauranteGateway;
    }

    public ItemCardapio executar(CriarItemCardapioRequest item) {
        Objects.requireNonNull(item, "item é obrigatório");
        Objects.requireNonNull(item.getRestauranteId(), "restaurante é obrigatório");

        Restaurante restaurante = restauranteGateway.buscarPorId(item.getRestauranteId())
                .orElseThrow(() -> new RestauranteNaoEncontradoException("Restaurante não encontrado"));


        ItemCardapio novoItem = new ItemCardapio(
                null,
                item.getNome(),
                item.getDescricao(),
                item.getPreco(),
                item.isApenasNoLocal(),
                item.getCaminhoFoto(),
                restaurante
        );
        return gateway.salvar(novoItem);
    }
}