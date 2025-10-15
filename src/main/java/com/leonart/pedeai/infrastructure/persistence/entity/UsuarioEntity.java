package com.leonart.pedeai.infrastructure.persistence.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "usuario")
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @ManyToOne
    @JoinColumn(name = "tipo_usuario_id")
    private TipoUsuarioEntity tipoUsuario;

    public UsuarioEntity() {}
    // getters and setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public TipoUsuarioEntity getTipoUsuario() { return tipoUsuario; }
    public void setTipoUsuario(TipoUsuarioEntity tipoUsuario) { this.tipoUsuario = tipoUsuario; }
}
