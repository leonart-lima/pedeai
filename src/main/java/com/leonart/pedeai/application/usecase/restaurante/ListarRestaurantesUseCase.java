package com.leonart.pedeai.application.usecase.restaurante;

import com.leonart.pedeai.domain.gateway.RestauranteGateway;
import com.leonart.pedeai.domain.model.Restaurante;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListarRestaurantesUseCase {

    private final RestauranteGateway gateway;

    public ListarRestaurantesUseCase(RestauranteGateway gateway) {
        this.gateway = gateway;
    }

    public List<Restaurante> executar() {
        return gateway.listarTodos();
    }
}