package com.leonart.pedeai.infrastructure.web.controller;

import com.leonart.pedeai.application.dto.request.RestauranteRequest;
import com.leonart.pedeai.application.usecase.restaurante.AtualizarRestauranteUseCase;
import com.leonart.pedeai.application.usecase.restaurante.BuscarRestaurantePorIdUseCase;
import com.leonart.pedeai.application.usecase.restaurante.CriarRestauranteUseCase;
import com.leonart.pedeai.application.usecase.restaurante.DeletarRestauranteUseCase;
import com.leonart.pedeai.application.usecase.restaurante.ListarRestaurantesUseCase;
import com.leonart.pedeai.domain.model.Restaurante;
import com.leonart.pedeai.infrastructure.persistence.mapper.RestauranteMapper;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

    private final ListarRestaurantesUseCase listarRestaurantesUseCase;
    private final BuscarRestaurantePorIdUseCase buscarRestaurantePorIdUseCase;
    private final CriarRestauranteUseCase criarRestauranteUseCase;
    private final AtualizarRestauranteUseCase atualizarRestauranteUseCase;
    private final DeletarRestauranteUseCase deletarRestauranteUseCase;

    public RestauranteController(ListarRestaurantesUseCase listarRestaurantesUseCase,
                                 BuscarRestaurantePorIdUseCase buscarRestaurantePorIdUseCase,
                                 CriarRestauranteUseCase criarRestauranteUseCase,
                                 AtualizarRestauranteUseCase atualizarRestauranteUseCase,
                                 DeletarRestauranteUseCase deletarRestauranteUseCase) {
        this.listarRestaurantesUseCase = listarRestaurantesUseCase;
        this.buscarRestaurantePorIdUseCase = buscarRestaurantePorIdUseCase;
        this.criarRestauranteUseCase = criarRestauranteUseCase;
        this.atualizarRestauranteUseCase = atualizarRestauranteUseCase;
        this.deletarRestauranteUseCase = deletarRestauranteUseCase;
    }

    @GetMapping
    public ResponseEntity<List<Restaurante>> listar() {
        List<Restaurante> restaurantes = listarRestaurantesUseCase.executar();
        return ResponseEntity.ok(restaurantes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurante> buscarPorId(@PathVariable UUID id) {
        Restaurante restaurante = buscarRestaurantePorIdUseCase.executar(id);
        return ResponseEntity.ok(restaurante);
    }

    @PostMapping
    public ResponseEntity<Restaurante> criar(@Valid @RequestBody RestauranteRequest request) {
        Restaurante criado = criarRestauranteUseCase.executar(request);

        return ResponseEntity.ok(criado);
    }


}