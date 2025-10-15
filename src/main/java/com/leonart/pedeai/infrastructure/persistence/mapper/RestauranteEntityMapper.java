package com.leonart.pedeai.infrastructure.persistence.mapper;

import com.leonart.pedeai.domain.model.ItemCardapio;
import com.leonart.pedeai.domain.model.Restaurante;
import com.leonart.pedeai.domain.model.Usuario;
import com.leonart.pedeai.infrastructure.persistence.entity.RestauranteEntity;
import com.leonart.pedeai.infrastructure.persistence.entity.ItemCardapioEntity;

import java.util.List;
import java.util.stream.Collectors;

public class RestauranteEntityMapper {
    public static Restaurante toDomain(RestauranteEntity e) {
        if (e == null) return null;
        Usuario dono = UsuarioEntityMapper.toDomain(e.getDono());
        List<ItemCardapio> itens = e.getItens() == null ? List.of() :
                e.getItens().stream()
                        .map(ItemCardapioEntityMapper::toDomain)
                        .collect(Collectors.toList());
        return new Restaurante(
                e.getId(),
                e.getNome(),
                e.getEndereco(),
                e.getTipoCozinha(),
                e.getHorarioFuncionamento(),
                dono,
                itens
        );
    }

    public static RestauranteEntity toEntity(Restaurante d) {
        if (d == null) return null;
        RestauranteEntity e = new RestauranteEntity();
        e.setId(d.getId());
        e.setNome(d.getNome());
        e.setEndereco(d.getEndereco());
        e.setTipoCozinha(d.getTipoCozinha());
        e.setHorarioFuncionamento(d.getHorarioFuncionamento());
        e.setDono(UsuarioEntityMapper.toEntity(d.getDono()));
        List<ItemCardapioEntity> itens = d.getItens() == null ? List.of() :
                d.getItens().stream()
                        .map(item -> ItemCardapioEntityMapper.toEntity(item, e))
                        .collect(Collectors.toList());
        e.setItens(itens);
        return e;
    }

    public static RestauranteEntity toEntitySave(Restaurante d) {
        if (d == null) return null;
        RestauranteEntity e = new RestauranteEntity();
        e.setId(null);
        e.setNome(d.getNome());
        e.setEndereco(d.getEndereco());
        e.setTipoCozinha(d.getTipoCozinha());
        e.setHorarioFuncionamento(d.getHorarioFuncionamento());
        e.setDono(UsuarioEntityMapper.toEntity(d.getDono()));
        List<ItemCardapioEntity> itens = d.getItens() == null ? List.of() :
                d.getItens().stream()
                        .map(item -> ItemCardapioEntityMapper.toEntity(item, e))
                        .collect(Collectors.toList());
        e.setItens(itens);
        return e;
    }
}