package com.leonart.pedeai.infrastructure.persistence.gateway.itemCardapio;

import com.leonart.pedeai.domain.exception.RestauranteNaoEncontradoException;
import com.leonart.pedeai.domain.gateway.ItemCardapioGateway;
import com.leonart.pedeai.domain.model.ItemCardapio;
import com.leonart.pedeai.infrastructure.persistence.entity.ItemCardapioEntity;
import com.leonart.pedeai.infrastructure.persistence.entity.RestauranteEntity;
import com.leonart.pedeai.infrastructure.persistence.gateway.restaurante.RestauranteJpaRepository;
import com.leonart.pedeai.infrastructure.persistence.mapper.ItemCardapioEntityMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class JpaItemCardapioGateway implements ItemCardapioGateway {

    private final ItemCardapioJpaRepository repository;
    private final RestauranteJpaRepository restauranteRepository;

    public JpaItemCardapioGateway(ItemCardapioJpaRepository repository, RestauranteJpaRepository restauranteRepository) {
        this.repository = repository;
        this.restauranteRepository = restauranteRepository;
    }

    @Override
    public ItemCardapio salvar(ItemCardapio item) {
        RestauranteEntity restaurante = restauranteRepository.findById(item.getRestaurante().getId())
                .orElseThrow(() -> new RestauranteNaoEncontradoException("Restaurante não encontrado com id: " + item.getRestaurante().getId()));
        ItemCardapioEntity entity = ItemCardapioEntityMapper.toEntity(item, restaurante);
        ItemCardapioEntity salvo = repository.save(entity);
        return ItemCardapioEntityMapper.toDomain(salvo);
    }

    @Override
    public Optional<ItemCardapio> buscarPorId(UUID id) {
        return repository.findById(id).map(ItemCardapioEntityMapper::toDomain);
    }

    @Override
    public List<ItemCardapio> listarPorRestaurante(UUID restauranteId) {
        return repository.findByRestauranteId(restauranteId).stream().map(ItemCardapioEntityMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public void deletar(UUID id) { repository.deleteById(id); }
}
