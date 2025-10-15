package com.leonart.pedeai.domain.model;

import java.util.Objects;
import java.util.UUID;

public final class TipoUsuario {
    private final UUID id;
    private final String nome;

    public TipoUsuario(UUID id, String nome) {
        if (nome == null || nome.isBlank()) throw new IllegalArgumentException("nome é obrigatório");
        this.id = id == null ? UUID.randomUUID() : id;
        this.nome = nome.trim();
    }

    public UUID getId() { return id; }
    public String getNome() { return nome; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TipoUsuario)) return false;
        TipoUsuario that = (TipoUsuario) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }
}
