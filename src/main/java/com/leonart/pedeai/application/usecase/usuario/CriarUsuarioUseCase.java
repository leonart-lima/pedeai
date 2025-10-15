package com.leonart.pedeai.application.usecase.usuario;

import com.leonart.pedeai.application.dto.request.UsuarioCriarRequest;
import com.leonart.pedeai.domain.exception.TipoUsuarioNaoEncontradoException;
import com.leonart.pedeai.domain.gateway.TipoUsuarioGateway;
import com.leonart.pedeai.domain.gateway.UsuarioGateway;
import com.leonart.pedeai.domain.model.TipoUsuario;
import com.leonart.pedeai.domain.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CriarUsuarioUseCase {
    private final UsuarioGateway usuarioGateway;
    private final TipoUsuarioGateway tipoUsuarioGateway;

    public CriarUsuarioUseCase(UsuarioGateway usuarioGateway, TipoUsuarioGateway tipoUsuarioGateway) {
        this.usuarioGateway = usuarioGateway;
        this.tipoUsuarioGateway = tipoUsuarioGateway;
    }

    public Usuario executar(Usuario usuario) {
        return usuarioGateway.salvar(usuario);
    }

    public Usuario executar(UsuarioCriarRequest request) {
        UUID idTipoUsuario = request.getIdTipoUsuario();
        Optional<TipoUsuario> tipoUsuarioOpt = tipoUsuarioGateway.buscarPorId(idTipoUsuario);
        if (tipoUsuarioOpt.isEmpty()) {
            throw new TipoUsuarioNaoEncontradoException("Tipo de usuario não cadastrado");
        }
        Usuario usuario = new Usuario(
                null,
                request.getNome(),
                request.getEmail(),
                tipoUsuarioOpt.get()
        );
        return usuarioGateway.salvar(usuario);
    }
}