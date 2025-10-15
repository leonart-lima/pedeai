package com.leonart.pedeai.application.usecase.tipoUsuario;

import com.leonart.pedeai.domain.gateway.TipoUsuarioGateway;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class DeletarTipoUsuarioUseCase {
    private final TipoUsuarioGateway tipoUsuarioGateway;

    public DeletarTipoUsuarioUseCase(TipoUsuarioGateway tipoUsuarioGateway) {
        this.tipoUsuarioGateway = tipoUsuarioGateway;
    }

    public void executar(UUID id) {
        tipoUsuarioGateway.deletar(id);
    }
}
