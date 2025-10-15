package com.leonart.pedeai.application.usecase.tipoUsuario;

import com.leonart.pedeai.domain.gateway.TipoUsuarioGateway;
import com.leonart.pedeai.domain.model.TipoUsuario;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class ListarTipoUsuarioUseCase {
    private final TipoUsuarioGateway tipoUsuarioGateway;

    public ListarTipoUsuarioUseCase(TipoUsuarioGateway tipoUsuarioGateway) {
        this.tipoUsuarioGateway = tipoUsuarioGateway;
    }

    public List<TipoUsuario> listarTodos() {
        return tipoUsuarioGateway.listarTodos();
    }
}
