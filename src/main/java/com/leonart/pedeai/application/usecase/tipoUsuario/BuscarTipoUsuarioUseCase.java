package com.leonart.pedeai.application.usecase.tipoUsuario;

import com.leonart.pedeai.domain.gateway.TipoUsuarioGateway;
import com.leonart.pedeai.domain.model.TipoUsuario;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
@Service
public class BuscarTipoUsuarioUseCase {
    private final TipoUsuarioGateway tipoUsuarioGateway;

    public BuscarTipoUsuarioUseCase(TipoUsuarioGateway tipoUsuarioGateway) {
        this.tipoUsuarioGateway = tipoUsuarioGateway;
    }

    public Optional<TipoUsuario> executar(UUID id) {
        return tipoUsuarioGateway.buscarPorId(id);
    }
}
