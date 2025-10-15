package com.leonart.pedeai.infrastructure.persistence.mapper;

import com.leonart.pedeai.domain.model.TipoUsuario;
import com.leonart.pedeai.domain.model.Usuario;
import com.leonart.pedeai.infrastructure.persistence.entity.TipoUsuarioEntity;
import com.leonart.pedeai.infrastructure.persistence.entity.UsuarioEntity;

public class UsuarioEntityMapper {
    public static Usuario toDomain(UsuarioEntity e) {
        if (e == null) return null;
        TipoUsuario t = e.getTipoUsuario() == null ? null : new TipoUsuario(e.getTipoUsuario().getId(), e.getTipoUsuario().getNome());
        return new Usuario(e.getId(), e.getNome(), e.getEmail(), t);
    }

    public static UsuarioEntity toEntity(Usuario d) {
        if (d == null) return null;
        UsuarioEntity e = new UsuarioEntity();
        e.setId(d.getId());
        e.setNome(d.getNome());
        e.setEmail(d.getEmail());
        if (d.getTipoUsuario() != null) {
            TipoUsuarioEntity te = new TipoUsuarioEntity(d.getTipoUsuario().getId(), d.getTipoUsuario().getNome());
            e.setTipoUsuario(te);
        }
        return e;
    }

    public static UsuarioEntity toEntitySave(Usuario d) {
        if (d == null) return null;
        UsuarioEntity e = new UsuarioEntity();
        e.setId(null);
        e.setNome(d.getNome());
        e.setEmail(d.getEmail());
        if (d.getTipoUsuario() != null) {
            TipoUsuarioEntity te = new TipoUsuarioEntity(d.getTipoUsuario().getId(), d.getTipoUsuario().getNome());
            e.setTipoUsuario(te);
        }
        return e;
    }
}
