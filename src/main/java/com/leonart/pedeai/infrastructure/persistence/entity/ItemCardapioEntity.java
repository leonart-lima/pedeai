package com.leonart.pedeai.infrastructure.persistence.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "item_cardapio")
public class ItemCardapioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String nome;

    private String descricao;

    @Column(nullable = false)
    private BigDecimal preco;

    @Column(name = "apenas_no_local")
    private boolean apenasNoLocal;

    private String caminhoFoto;

    @ManyToOne
    @JoinColumn(name = "restaurante_id")
    private RestauranteEntity restaurante;

    public ItemCardapioEntity() {}
    // getters/setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public BigDecimal getPreco() { return preco; }
    public void setPreco(BigDecimal preco) { this.preco = preco; }
    public boolean isApenasNoLocal() { return apenasNoLocal; }
    public void setApenasNoLocal(boolean apenasNoLocal) { this.apenasNoLocal = apenasNoLocal; }
    public String getCaminhoFoto() { return caminhoFoto; }
    public void setCaminhoFoto(String caminhoFoto) { this.caminhoFoto = caminhoFoto; }
    public RestauranteEntity getRestaurante() { return restaurante; }
    public void setRestaurante(RestauranteEntity restaurante) { this.restaurante = restaurante; }
}
