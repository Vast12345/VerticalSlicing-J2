package com.repasojava.Pais.application;

import java.util.Optional;

import com.repasojava.Pais.domain.entity.Pais;
import com.repasojava.Pais.domain.service.PaisService;

public class FindPaisUseCase {
    private final PaisService paisService;

    public FindPaisUseCase(PaisService paisService) {
        this.paisService = paisService;
    }

    public Optional<Pais> execute(Long id) {
        return paisService.findPaisById(id);
    }
}
