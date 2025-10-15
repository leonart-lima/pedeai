package com.leonart.pedeai.application.usecase.restaurante;

import com.leonart.pedeai.application.dto.request.RestauranteRequest;
import com.leonart.pedeai.domain.exception.UsuarioNaoEncontradoException;
import com.leonart.pedeai.domain.gateway.RestauranteGateway;
import com.leonart.pedeai.domain.gateway.UsuarioGateway;
import com.leonart.pedeai.domain.model.Restaurante;
import com.leonart.pedeai.domain.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
public class CriarRestauranteUseCase {

    private final RestauranteGateway restauranteGateway;
    private final UsuarioGateway usuarioGateway;

    public CriarRestauranteUseCase(RestauranteGateway restauranteGateway, UsuarioGateway usuarioGateway) {
        this.restauranteGateway = restauranteGateway;
        this.usuarioGateway = usuarioGateway;
    }

    public Restaurante executar(RestauranteRequest restaurante) {
        Objects.requireNonNull(restaurante, "restaurante é obrigatório");

        Usuario usuario = usuarioGateway.buscarPorId(restaurante.getDonoId())
                .orElseThrow(() -> new UsuarioNaoEncontradoException("Usuário do dono não cadastrado"));

        Restaurante novoRestaurante = new Restaurante(
                null,
                restaurante.getNome(),
                restaurante.getEndereco(),
                restaurante.getTipoCozinha(),
                restaurante.getHorarioFuncionamento(),
                usuario,
                null
        );

        return restauranteGateway.salvar(novoRestaurante);
    }
}