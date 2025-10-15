package com.leonart.pedeai.application.usecase.usuario;

import com.leonart.pedeai.domain.exception.UsuarioNaoEncontradoException;
import com.leonart.pedeai.domain.gateway.UsuarioGateway;
import com.leonart.pedeai.domain.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class BuscarUsuarioUseCase {

    private final UsuarioGateway usuarioGateway;

    public BuscarUsuarioUseCase(UsuarioGateway usuarioGateway) {
        this.usuarioGateway = usuarioGateway;
    }

    public Optional<Usuario> executar(UUID id) {
        Optional<Usuario> usuario = usuarioGateway.buscarPorId(id);

        if (usuario.isEmpty()) {
            throw new UsuarioNaoEncontradoException("Usuario não cadastrado");
        }
        return usuarioGateway.buscarPorId(id);
    }
}