package com.leonart.pedeai.application.dto.request;

import jakarta.validation.constraints.NotBlank;

public class TipoUsuarioCriarRequest {
    @NotBlank
    private String nome;

    public TipoUsuarioCriarRequest() {}
    public TipoUsuarioCriarRequest(String nome) { this.nome = nome; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
}
