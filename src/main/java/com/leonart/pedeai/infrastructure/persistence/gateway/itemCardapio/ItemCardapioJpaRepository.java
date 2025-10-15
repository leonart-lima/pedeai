// src/main/java/com/techchallenge/infrastructure/persistence/gateway/ItemCardapioJpaRepository.java
package com.leonart.pedeai.infrastructure.persistence.gateway.itemCardapio;

import com.leonart.pedeai.infrastructure.persistence.entity.ItemCardapioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ItemCardapioJpaRepository extends JpaRepository<ItemCardapioEntity, UUID> {
    List<ItemCardapioEntity> findByRestauranteId(UUID restauranteId);
}
