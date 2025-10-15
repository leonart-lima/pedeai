package com.leonart.pedeai.infrastructure.persistence.gateway.usuario;

import com.leonart.pedeai.infrastructure.persistence.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface UsuarioJpaRepository extends JpaRepository<UsuarioEntity, UUID> {
}
