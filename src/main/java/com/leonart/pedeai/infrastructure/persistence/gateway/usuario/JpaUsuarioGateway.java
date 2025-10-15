package com.leonart.pedeai.infrastructure.persistence.gateway.usuario;

import com.leonart.pedeai.domain.gateway.UsuarioGateway;
import com.leonart.pedeai.domain.model.Usuario;
import com.leonart.pedeai.infrastructure.persistence.entity.TipoUsuarioEntity;
import com.leonart.pedeai.infrastructure.persistence.entity.UsuarioEntity;
import com.leonart.pedeai.infrastructure.persistence.gateway.tipoUsuario.TipoUsuarioJpaRepository;
import com.leonart.pedeai.infrastructure.persistence.mapper.UsuarioEntityMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class JpaUsuarioGateway implements UsuarioGateway {

    private final UsuarioJpaRepository usuarioRepository;
    private final TipoUsuarioJpaRepository tipoUsuarioRepository;

    public JpaUsuarioGateway(UsuarioJpaRepository usuarioRepository, TipoUsuarioJpaRepository tipoUsuarioRepository) {
        this.usuarioRepository = usuarioRepository;
        this.tipoUsuarioRepository = tipoUsuarioRepository;
    }
    @Override
    public Usuario salvar(Usuario usuario) {
        TipoUsuarioEntity tipoUsuarioEntity = tipoUsuarioRepository.findById(usuario.getTipoUsuario().getId())
                .orElseThrow(() -> new IllegalArgumentException("Tipo de usuário não encontrado"));

        UsuarioEntity usuarioEntity = UsuarioEntityMapper.toEntitySave(usuario);
        usuarioEntity.setTipoUsuario(tipoUsuarioEntity);
        UsuarioEntity salvo = usuarioRepository.save(usuarioEntity);

        return UsuarioEntityMapper.toDomain(salvo);
    }

    @Override
    public Optional<Usuario> buscarPorId(UUID id) {
        return usuarioRepository.findById(id).map(UsuarioEntityMapper::toDomain);
    }

    @Override
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll().stream().map(UsuarioEntityMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public void deletar(UUID id) {
        usuarioRepository.deleteById(id);
    }
}
