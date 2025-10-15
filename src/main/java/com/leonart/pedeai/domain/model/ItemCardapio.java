package com.leonart.pedeai.domain.model;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public final class ItemCardapio {
    private final UUID id;
    private final String nome;
    private final String descricao;
    private final BigDecimal preco;
    private final boolean apenasNoLocal;
    private final String caminhoFoto;
    private final Restaurante restaurante;

    public ItemCardapio(UUID id, String nome, String descricao, BigDecimal preco, boolean apenasNoLocal, String caminhoFoto, Restaurante restaurante) {
        if (nome == null || nome.isBlank()) throw new IllegalArgumentException("nome é obrigatório");
        if (preco == null || preco.compareTo(BigDecimal.ZERO) < 0) throw new IllegalArgumentException("preco inválido");
        this.id = id == null ? UUID.randomUUID() : id;
        this.nome = nome.trim();
        this.descricao = descricao == null ? "" : descricao.trim();
        this.preco = preco;
        this.apenasNoLocal = apenasNoLocal;
        this.caminhoFoto = caminhoFoto == null ? "" : caminhoFoto.trim();
        this.restaurante = restaurante; // Faltava esta linha
    }

    public UUID getId() { return id; }
    public String getNome() { return nome; }
    public String getDescricao() { return descricao; }
    public BigDecimal getPreco() { return preco; }
    public boolean isApenasNoLocal() { return apenasNoLocal; }
    public String getCaminhoFoto() { return caminhoFoto; }
    public Restaurante getRestaurante() { return restaurante; } // Getter adicionado

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemCardapio)) return false;
        ItemCardapio that = (ItemCardapio) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }
}