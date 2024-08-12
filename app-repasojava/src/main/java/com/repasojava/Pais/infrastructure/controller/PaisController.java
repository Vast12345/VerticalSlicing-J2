package com.repasojava.Pais.infrastructure.controller;

import javax.swing.JOptionPane;

import com.repasojava.Pais.application.CreatePaisUseCase;
import com.repasojava.Pais.application.FindPaisUseCase;
import com.repasojava.Pais.domain.entity.Pais;
import com.repasojava.Pais.domain.service.PaisService;
import com.repasojava.Pais.infrastructure.repository.PaisRepository;

public class PaisController {
    PaisService paisService;
    CreatePaisUseCase createPaisUseCase;
    FindPaisUseCase findPaisUseCase;

    public PaisController() {
        paisService = new PaisRepository();
        createPaisUseCase = new CreatePaisUseCase(paisService);
        findPaisUseCase = new FindPaisUseCase(paisService);
    }

    public void mainMenu() {
        String opciones = "1. Add Country\n2. Search Country\n3. Exit";
        int op;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(null, opciones));
            switch (op) {
                case 1:
                    addPais();
                    break;
                case 2:
                    findPais();
                case 3:
                    break;
                default:
                JOptionPane.showMessageDialog(null, "Error opcion invalida", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        } while(op!=3);
    }

    public void addPais() {

            String name = JOptionPane.showInputDialog(null, "Add Country Name: ");

            Pais pais = new Pais();
            pais.setName(name);

            createPaisUseCase.execute(pais);

        System.out.println("Country created successfully");
    }

    public void findPais() {
        try {
            Long id = Long.parseLong(JOptionPane.showInputDialog(null, "Enter Country ID: "));
            findPaisUseCase.execute(id).ifPresentOrElse(foundPais -> {
                JOptionPane.showMessageDialog(null, foundPais.toString());
                foundPais.toString();
        }, () -> {
        });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
