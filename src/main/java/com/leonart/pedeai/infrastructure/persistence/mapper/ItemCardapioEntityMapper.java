package com.leonart.pedeai.infrastructure.persistence.mapper;

import com.leonart.pedeai.domain.model.ItemCardapio;
import com.leonart.pedeai.domain.model.Restaurante;
import com.leonart.pedeai.infrastructure.persistence.entity.ItemCardapioEntity;
import com.leonart.pedeai.infrastructure.persistence.entity.RestauranteEntity;

public class ItemCardapioEntityMapper {

    public static ItemCardapio toDomain(ItemCardapioEntity e) {
        if (e == null) return null;
        Restaurante restaurante = new Restaurante(e.getRestaurante().getId(), e.getRestaurante().getNome(), null, null, null, null, null); // apenas dados essenciais
        return new ItemCardapio(
                e.getId(),
                e.getNome(),
                e.getDescricao(),
                e.getPreco(),
                e.isApenasNoLocal(),
                e.getCaminhoFoto(),
                restaurante
        );
    }

    public static ItemCardapioEntity toEntity(ItemCardapio d, RestauranteEntity restauranteEntity) {
        if (d == null) return null;
        ItemCardapioEntity e = new ItemCardapioEntity();
        e.setId(d.getId());
        e.setNome(d.getNome());
        e.setDescricao(d.getDescricao());
        e.setPreco(d.getPreco());
        e.setApenasNoLocal(d.isApenasNoLocal());
        e.setCaminhoFoto(d.getCaminhoFoto());
        e.setRestaurante(restauranteEntity);
        return e;
    }
}