package com.leonart.pedeai.infrastructure.web.controller;
import com.leonart.pedeai.application.dto.request.TipoUsuarioCriarRequest;
import com.leonart.pedeai.application.dto.response.TipoUsuarioResponse;
import com.leonart.pedeai.application.usecase.tipoUsuario.BuscarTipoUsuarioUseCase;
import com.leonart.pedeai.application.usecase.tipoUsuario.CriarTipoUsuarioUseCase;
import com.leonart.pedeai.application.usecase.tipoUsuario.DeletarTipoUsuarioUseCase;
import com.leonart.pedeai.application.usecase.tipoUsuario.ListarTipoUsuarioUseCase;
import com.leonart.pedeai.domain.model.TipoUsuario;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tipos-usuario")
public class TipoUsuarioController {

    private final CriarTipoUsuarioUseCase criarUseCase;
    private final ListarTipoUsuarioUseCase listarUseCase;
    private final BuscarTipoUsuarioUseCase buscarUseCase;
    private final DeletarTipoUsuarioUseCase deletarUseCase;

    public TipoUsuarioController(CriarTipoUsuarioUseCase criarUseCase,
                                 ListarTipoUsuarioUseCase listarUseCase,
                                 BuscarTipoUsuarioUseCase buscarUseCase,
                                 DeletarTipoUsuarioUseCase deletarUseCase) {
        this.criarUseCase = criarUseCase;
        this.listarUseCase = listarUseCase;
        this.buscarUseCase = buscarUseCase;
        this.deletarUseCase = deletarUseCase;
    }

    @PostMapping
    public ResponseEntity<TipoUsuarioResponse> criar(@Valid @RequestBody TipoUsuarioCriarRequest req) {
        TipoUsuario salvo = criarUseCase.executar(req.getNome());
        TipoUsuarioResponse resp = new TipoUsuarioResponse(salvo.getId(), salvo.getNome());
        return ResponseEntity.status(201).body(resp);
    }

    @GetMapping
    public ResponseEntity<List<TipoUsuarioResponse>> listar() {
        List<TipoUsuarioResponse> list = listarUseCase.listarTodos().stream().map(t -> new TipoUsuarioResponse(t.getId(), t.getNome())).collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoUsuarioResponse> buscar(@PathVariable UUID id) {
        return buscarUseCase.executar(id)
                .map(t -> ResponseEntity.ok(new TipoUsuarioResponse(t.getId(), t.getNome())))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
