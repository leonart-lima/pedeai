package com.leonart.pedeai.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;

public class RestauranteRequest {
    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @NotBlank(message = "O endereço é obrigatório")
    private String endereco;

    @NotBlank(message = "O tipo de cozinha é obrigatório")
    private String tipoCozinha;

    @NotBlank(message = "O horário de funcionamento é obrigatório")
    private String horarioFuncionamento;

    @NotNull(message = "O donoId é obrigatório")
    private UUID donoId;

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    public String getTipoCozinha() { return tipoCozinha; }
    public void setTipoCozinha(String tipoCozinha) { this.tipoCozinha = tipoCozinha; }

    public String getHorarioFuncionamento() { return horarioFuncionamento; }
    public void setHorarioFuncionamento(String horarioFuncionamento) { this.horarioFuncionamento = horarioFuncionamento; }

    public UUID getDonoId() { return donoId; }
    public void setDonoId(UUID donoId) { this.donoId = donoId; }

}