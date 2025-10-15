package com.leonart.pedeai.domain.model;

import java.util.Objects;
import java.util.UUID;

public final class Usuario {
    private final UUID id;
    private final String nome;
    private final String email;
    private final TipoUsuario tipoUsuario;

    public Usuario(UUID id, String nome, String email, TipoUsuario tipoUsuario) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("nome é obrigatório");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("email é obrigatório");
        }
        this.id = id == null ? UUID.randomUUID() : id;
        this.nome = nome.trim();
        this.email = email.trim().toLowerCase();
        this.tipoUsuario = tipoUsuario;
    }

    public UUID getId() { return id; }
    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public TipoUsuario getTipoUsuario() { return tipoUsuario; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;
        Usuario usuario = (Usuario) o;
        return id.equals(usuario.id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }
}
