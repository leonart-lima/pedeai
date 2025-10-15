
package com.leonart.pedeai.infrastructure.persistence.gateway.restaurante;

import com.leonart.pedeai.domain.gateway.RestauranteGateway;
import com.leonart.pedeai.domain.gateway.UsuarioGateway;
import com.leonart.pedeai.domain.model.Restaurante;
import com.leonart.pedeai.infrastructure.persistence.entity.RestauranteEntity;
import com.leonart.pedeai.infrastructure.persistence.entity.UsuarioEntity;
import com.leonart.pedeai.infrastructure.persistence.gateway.usuario.UsuarioJpaRepository;
import com.leonart.pedeai.infrastructure.persistence.mapper.RestauranteEntityMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class JpaRestauranteGateway implements RestauranteGateway {

    private final RestauranteJpaRepository repository;
    private final UsuarioJpaRepository usuarioRepository;

    public JpaRestauranteGateway(RestauranteJpaRepository repository, UsuarioJpaRepository usuarioRepository) {
        this.repository = repository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Restaurante salvar(Restaurante restaurante) {
        UsuarioEntity dono = usuarioRepository.getReferenceById(restaurante.getDono().getId());
        RestauranteEntity entity = RestauranteEntityMapper.toEntitySave(restaurante);
        entity.setDono(dono);
        RestauranteEntity salvo = repository.save(entity);
        return RestauranteEntityMapper.toDomain(salvo);
    }

    @Override
    public Optional<Restaurante> buscarPorId(UUID id) {
        return repository.findById(id).map(RestauranteEntityMapper::toDomain);
    }

    @Override
    public List<Restaurante> listarTodos() {
        return repository.findAll().stream().map(RestauranteEntityMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public void deletar(UUID id) {
        repository.deleteById(id);
    }
}
