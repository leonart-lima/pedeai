package com.leonart.pedeai.infrastructure.persistence.mapper;

import com.leonart.pedeai.application.dto.request.RestauranteRequest;
import com.leonart.pedeai.domain.model.Restaurante;
import com.leonart.pedeai.domain.model.ItemCardapio;
import com.leonart.pedeai.domain.model.Usuario;

import java.util.List;
import java.util.stream.Collectors;

public class RestauranteMapper {

    public static Restaurante toEntity(RestauranteRequest request) {
        Usuario dono = new Usuario(request.getDonoId(), null, null, null);

        return new Restaurante(null,
                request.getNome(),
                request.getEndereco(),
                request.getTipoCozinha(),
                request.getHorarioFuncionamento(),
                dono,
                null
        );
    }

}