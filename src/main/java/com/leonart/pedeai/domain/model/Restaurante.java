package com.leonart.pedeai.domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public final class Restaurante {
    private final UUID id;
    private final String nome;
    private final String endereco;
    private final String tipoCozinha;
    private final String horarioFuncionamento;
    private final Usuario dono;
    private final List<ItemCardapio> itens;

    public Restaurante(UUID id, String nome, String endereco, String tipoCozinha, String horarioFuncionamento, Usuario dono, List<ItemCardapio> itens) {
        if (nome == null || nome.isBlank()) throw new IllegalArgumentException("nome é obrigatório");
        this.id = id == null ? UUID.randomUUID() : id;
        this.nome = nome.trim();
        this.endereco = endereco == null ? "" : endereco.trim();
        this.tipoCozinha = tipoCozinha == null ? "" : tipoCozinha.trim();
        this.horarioFuncionamento = horarioFuncionamento == null ? "" : horarioFuncionamento.trim();
        this.dono = dono;
        this.itens = itens == null ? new ArrayList<>() : new ArrayList<>(itens);
    }

    public UUID getId() { return id; }
    public String getNome() { return nome; }
    public String getEndereco() { return endereco; }
    public String getTipoCozinha() { return tipoCozinha; }
    public String getHorarioFuncionamento() { return horarioFuncionamento; }
    public Usuario getDono() { return dono; }
    public List<ItemCardapio> getItens() { return List.copyOf(itens); }

    public void adicionarItem(ItemCardapio item) {
        if (item == null) throw new IllegalArgumentException("item é obrigatório");
        itens.add(item);
    }

    public void removerItem(ItemCardapio item) { itens.remove(item); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Restaurante)) return false;
        Restaurante that = (Restaurante) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }
}
