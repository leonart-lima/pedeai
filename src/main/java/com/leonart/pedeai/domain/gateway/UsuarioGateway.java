package com.leonart.pedeai.domain.gateway;


import com.leonart.pedeai.domain.model.Usuario;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UsuarioGateway {
    Usuario salvar(Usuario usuario);
    Optional<Usuario> buscarPorId(UUID id);
    List<Usuario> listarTodos();
    void deletar(UUID id);
}
