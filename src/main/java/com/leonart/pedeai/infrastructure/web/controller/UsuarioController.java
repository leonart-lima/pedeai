package com.leonart.pedeai.infrastructure.web.controller;

import com.leonart.pedeai.application.dto.request.UsuarioCriarRequest;
import com.leonart.pedeai.application.usecase.usuario.BuscarUsuarioUseCase;
import com.leonart.pedeai.application.usecase.usuario.CriarUsuarioUseCase;
import com.leonart.pedeai.application.usecase.usuario.DeletarUsuarioUseCase;
import com.leonart.pedeai.application.usecase.usuario.ListarUsuarioUseCase;
import com.leonart.pedeai.domain.model.TipoUsuario;
import com.leonart.pedeai.domain.model.Usuario;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final BuscarUsuarioUseCase buscarUsuarioUseCase;
    private final CriarUsuarioUseCase criarUsuarioUseCase;
    private final DeletarUsuarioUseCase deletarUsuarioUseCase;
    private final ListarUsuarioUseCase listarUsuarioUseCase;

    public UsuarioController(
            BuscarUsuarioUseCase buscarUsuarioUseCase,
            CriarUsuarioUseCase criarUsuarioUseCase,
            DeletarUsuarioUseCase deletarUsuarioUseCase,
            ListarUsuarioUseCase listarUsuarioUseCase
    ) {
        this.buscarUsuarioUseCase = buscarUsuarioUseCase;
        this.criarUsuarioUseCase = criarUsuarioUseCase;
        this.deletarUsuarioUseCase = deletarUsuarioUseCase;
        this.listarUsuarioUseCase = listarUsuarioUseCase;
    }

    @GetMapping
    public List<Usuario> listar() {
        return listarUsuarioUseCase.executar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable UUID id) {
        Optional<Usuario> usuario = buscarUsuarioUseCase.executar(id);
        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Usuario> criar(@Valid @RequestBody UsuarioCriarRequest usuarioRequest) {

        Usuario criado = criarUsuarioUseCase.executar(usuarioRequest);
        return ResponseEntity.ok(criado);
    }

}