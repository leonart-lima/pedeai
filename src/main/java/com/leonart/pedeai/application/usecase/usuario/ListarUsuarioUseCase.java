package com.leonart.pedeai.application.usecase.usuario;

import com.leonart.pedeai.domain.gateway.UsuarioGateway;
import com.leonart.pedeai.domain.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ListarUsuarioUseCase {
    private final UsuarioGateway usuarioGateway;

    public ListarUsuarioUseCase(UsuarioGateway usuarioGateway) {
        this.usuarioGateway = usuarioGateway;
    }

    public List<Usuario> executar() {
        return usuarioGateway.listarTodos();
    }
}