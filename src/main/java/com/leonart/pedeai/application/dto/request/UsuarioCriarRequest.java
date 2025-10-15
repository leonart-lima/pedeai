package com.leonart.pedeai.application.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class UsuarioCriarRequest {
    @NotBlank
    private String nome;

    @NotBlank
    @Email
    private String email;

    @NotNull
    private UUID idTipoUsuario;

    public UsuarioCriarRequest() {}

    public UsuarioCriarRequest(String nome, String email, UUID idTipoUsuario) {
        this.nome = nome;
        this.email = email;
        this.idTipoUsuario = idTipoUsuario;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public UUID getIdTipoUsuario() { return idTipoUsuario; }
    public void setIdTipoUsuario(UUID idTipoUsuario) { this.idTipoUsuario = idTipoUsuario; }

}