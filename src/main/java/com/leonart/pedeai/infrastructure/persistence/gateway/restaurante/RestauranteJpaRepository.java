// src/main/java/com/techchallenge/infrastructure/persistence/gateway/RestauranteJpaRepository.java
package com.leonart.pedeai.infrastructure.persistence.gateway.restaurante;

import com.leonart.pedeai.infrastructure.persistence.entity.RestauranteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface RestauranteJpaRepository extends JpaRepository<RestauranteEntity, UUID> {
}
