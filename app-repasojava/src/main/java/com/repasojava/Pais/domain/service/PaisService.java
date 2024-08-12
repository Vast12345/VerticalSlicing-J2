package com.repasojava.Pais.domain.service;

import java.util.Optional;

import com.repasojava.Pais.domain.entity.Pais;

public interface PaisService {
    void createPais(Pais pais);
    Optional<Pais> findPaisById(Long id);
    void update(Long id);
}
