package com.leonart.pedeai.application.dto.request;

import java.math.BigDecimal;
import java.util.UUID;

public class CriarItemCardapioRequest {
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private boolean apenasNoLocal;
    private String caminhoFoto;
    private UUID restauranteId;

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public BigDecimal getPreco() { return preco; }
    public void setPreco(BigDecimal preco) { this.preco = preco; }

    public UUID getRestauranteId() { return restauranteId; }
    public void setRestauranteId(UUID restauranteId) { this.restauranteId = restauranteId; }

    public boolean isApenasNoLocal() { return apenasNoLocal; }
    public void setApenasNoLocal(boolean apenasNoLocal) { this.apenasNoLocal = apenasNoLocal; }

    public String getCaminhoFoto() { return caminhoFoto; }
    public void setCaminhoFoto(String caminhoFoto) { this.caminhoFoto = caminhoFoto; }

}