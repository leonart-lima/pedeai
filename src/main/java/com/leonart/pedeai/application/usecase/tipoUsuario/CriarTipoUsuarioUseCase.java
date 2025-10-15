package com.leonart.pedeai.application.usecase.tipoUsuario;

import com.leonart.pedeai.domain.gateway.TipoUsuarioGateway;
import com.leonart.pedeai.domain.model.TipoUsuario;
import org.springframework.stereotype.Service;

@Service
public class CriarTipoUsuarioUseCase {

    private final TipoUsuarioGateway tipoUsuarioGateway;

    public CriarTipoUsuarioUseCase(TipoUsuarioGateway tipoUsuarioGateway) {
        this.tipoUsuarioGateway = tipoUsuarioGateway;
    }

    public TipoUsuario executar(String nome) {
        TipoUsuario t = new TipoUsuario(null, nome);
        return tipoUsuarioGateway.salvar(t);
    }
}
