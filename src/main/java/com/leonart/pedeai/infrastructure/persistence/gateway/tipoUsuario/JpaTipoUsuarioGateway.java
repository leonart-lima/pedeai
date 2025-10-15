package com.leonart.pedeai.infrastructure.persistence.gateway.tipoUsuario;

import com.leonart.pedeai.domain.gateway.TipoUsuarioGateway;
import com.leonart.pedeai.domain.model.TipoUsuario;
import com.leonart.pedeai.infrastructure.persistence.entity.TipoUsuarioEntity;
import com.leonart.pedeai.infrastructure.persistence.mapper.TipoUsuarioEntityMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class JpaTipoUsuarioGateway implements TipoUsuarioGateway {

    private final TipoUsuarioJpaRepository repository;

    public JpaTipoUsuarioGateway(TipoUsuarioJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public TipoUsuario salvar(TipoUsuario tipoUsuario) {
        TipoUsuarioEntity entity = TipoUsuarioEntityMapper.toEntitySave(tipoUsuario);
        TipoUsuarioEntity salvo = repository.save(entity);
        return TipoUsuarioEntityMapper.toDomain(salvo);
    }

    @Override
    public Optional<TipoUsuario> buscarPorId(UUID id) {
        return repository.findById(id).map(TipoUsuarioEntityMapper::toDomain);
    }

    @Override
    public List<TipoUsuario> listarTodos() {
        return repository.findAll().stream().map(TipoUsuarioEntityMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public void deletar(UUID id) {
        repository.deleteById(id);
    }
}
