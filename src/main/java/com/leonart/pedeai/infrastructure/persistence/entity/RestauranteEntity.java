package com.leonart.pedeai.infrastructure.persistence.entity;

import jakarta.persistence.*;
import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "restaurante")
public class RestauranteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String nome;

    private String endereco;
    private String tipoCozinha;
    private String horarioFuncionamento;

    @ManyToOne
    @JoinColumn(name = "dono_id")
    private UsuarioEntity dono;

    @OneToMany(mappedBy = "restaurante", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemCardapioEntity> itens = new ArrayList<>();

    public RestauranteEntity() {}
    // getters/setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }
    public String getTipoCozinha() { return tipoCozinha; }
    public void setTipoCozinha(String tipoCozinha) { this.tipoCozinha = tipoCozinha; }
    public String getHorarioFuncionamento() { return horarioFuncionamento; }
    public void setHorarioFuncionamento(String horarioFuncionamento) { this.horarioFuncionamento = horarioFuncionamento; }
    public UsuarioEntity getDono() { return dono; }
    public void setDono(UsuarioEntity dono) { this.dono = dono; }
    public List<ItemCardapioEntity> getItens() { return itens; }
    public void setItens(List<ItemCardapioEntity> itens) { this.itens = itens; }
}
