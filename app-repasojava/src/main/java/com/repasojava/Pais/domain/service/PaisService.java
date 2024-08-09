package com.repasojava.Pais.domain.service;

import com.repasojava.Pais.domain.entity.Pais;

public interface PaisService {
    void createPais(Pais pais);
    void findPaisById(Long id);
}
