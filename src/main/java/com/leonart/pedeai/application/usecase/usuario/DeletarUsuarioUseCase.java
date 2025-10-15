package com.leonart.pedeai.application.usecase.usuario;

import com.leonart.pedeai.domain.gateway.UsuarioGateway;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class DeletarUsuarioUseCase {
    private final UsuarioGateway usuarioGateway;

    public DeletarUsuarioUseCase(UsuarioGateway usuarioGateway) {
        this.usuarioGateway = usuarioGateway;
    }

    public void executar(UUID id) {
        usuarioGateway.deletar(id);
    }
}