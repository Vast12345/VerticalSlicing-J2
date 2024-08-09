package com.repasojava;

import com.repasojava.Pais.application.CreatePaisUseCase;
import com.repasojava.Pais.domain.service.PaisService;
import com.repasojava.Pais.infrastructure.controller.PaisController;
import com.repasojava.Pais.infrastructure.repository.PaisRepository;

public class Main {
    public static void main(String[] args) {
        PaisService paisService = new PaisRepository();
        CreatePaisUseCase createPaisUseCase = new CreatePaisUseCase(paisService);
        PaisController consoleAdapter = new PaisController(createPaisUseCase);
        
        consoleAdapter.AddPais();
    }
}