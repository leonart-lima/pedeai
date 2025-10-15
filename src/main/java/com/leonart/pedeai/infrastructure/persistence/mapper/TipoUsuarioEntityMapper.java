package com.leonart.pedeai.infrastructure.persistence.mapper;


import com.leonart.pedeai.domain.model.TipoUsuario;
import com.leonart.pedeai.infrastructure.persistence.entity.TipoUsuarioEntity;

public class TipoUsuarioEntityMapper {
    public static TipoUsuario toDomain(TipoUsuarioEntity e) {
        if (e == null) return null;
        return new TipoUsuario(e.getId(), e.getNome());
    }

    public static TipoUsuarioEntity toEntity(TipoUsuario d) {
        if (d == null) return null;
        return new TipoUsuarioEntity(d.getId(), d.getNome());
    }

    public static TipoUsuarioEntity toEntitySave(TipoUsuario d) {
        if (d == null) return null;
        return new TipoUsuarioEntity(null, d.getNome());
    }

    public static void copyToEntity(TipoUsuario d, TipoUsuarioEntity e) {
        if (d == null || e == null) return;
        e.setNome(d.getNome());
    }
}
