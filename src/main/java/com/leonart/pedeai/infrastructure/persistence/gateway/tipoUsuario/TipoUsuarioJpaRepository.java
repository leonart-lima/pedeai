// src/main/java/com/techchallenge/infrastructure/persistence/gateway/TipoUsuarioJpaRepository.java
package com.leonart.pedeai.infrastructure.persistence.gateway.tipoUsuario;

import com.leonart.pedeai.infrastructure.persistence.entity.TipoUsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface TipoUsuarioJpaRepository extends JpaRepository<TipoUsuarioEntity, UUID> {
}
