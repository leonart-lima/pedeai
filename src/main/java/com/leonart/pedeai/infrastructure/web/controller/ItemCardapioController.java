package com.leonart.pedeai.infrastructure.web.controller;

import com.leonart.pedeai.application.dto.request.CriarItemCardapioRequest;
import com.leonart.pedeai.application.usecase.itemCardapio.*;
import com.leonart.pedeai.domain.model.ItemCardapio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/itens-cardapio")
public class ItemCardapioController {

    private final ListarItensCardapioPorRestauranteUseCase listarItensCardapioPorRestauranteUseCase;
    private final BuscarItemCardapioPorIdUseCase buscarItemCardapioPorIdUseCase;
    private final CriarItemCardapioUseCase criarItemCardapioUseCase;
    private final AtualizarItemCardapioUseCase atualizarItemCardapioUseCase;
    private final DeletarItemCardapioUseCase deletarItemCardapioUseCase;

    public ItemCardapioController(
            ListarItensCardapioPorRestauranteUseCase listarItensCardapioPorRestauranteUseCase,
            BuscarItemCardapioPorIdUseCase buscarItemCardapioPorIdUseCase,
            CriarItemCardapioUseCase criarItemCardapioUseCase,
            AtualizarItemCardapioUseCase atualizarItemCardapioUseCase,
            DeletarItemCardapioUseCase deletarItemCardapioUseCase
    ) {
        this.listarItensCardapioPorRestauranteUseCase = listarItensCardapioPorRestauranteUseCase;
        this.buscarItemCardapioPorIdUseCase = buscarItemCardapioPorIdUseCase;
        this.criarItemCardapioUseCase = criarItemCardapioUseCase;
        this.atualizarItemCardapioUseCase = atualizarItemCardapioUseCase;
        this.deletarItemCardapioUseCase = deletarItemCardapioUseCase;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemCardapio> buscarPorId(@PathVariable UUID id) {
        ItemCardapio item = buscarItemCardapioPorIdUseCase.executar(id);
        return ResponseEntity.ok(item);
    }

    @PostMapping
    public ResponseEntity<ItemCardapio> criar(@RequestBody CriarItemCardapioRequest request) {
        ItemCardapio criado = criarItemCardapioUseCase.executar(request);
        return ResponseEntity.status(201).body(criado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemCardapio> atualizar(@PathVariable UUID id, @RequestBody ItemCardapio item) {
        ItemCardapio atualizado = atualizarItemCardapioUseCase.executar(id, item);
        return ResponseEntity.ok(atualizado);
    }

}