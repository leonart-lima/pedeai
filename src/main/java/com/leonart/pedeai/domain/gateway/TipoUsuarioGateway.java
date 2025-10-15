package com.leonart.pedeai.domain.gateway;

import com.leonart.pedeai.domain.model.TipoUsuario;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TipoUsuarioGateway {
    TipoUsuario salvar(TipoUsuario tipoUsuario);
    Optional<TipoUsuario> buscarPorId(UUID id);
    List<TipoUsuario> listarTodos();
    void deletar(UUID id);
}
