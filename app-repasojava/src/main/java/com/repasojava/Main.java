package com.repasojava;


import javax.swing.JOptionPane;

import com.repasojava.Pais.infrastructure.controller.PaisController;


public class Main {
    public static void main(String[] args) {
        

        String opciones = "1. Country Module\n2. Exit";
        int op;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(null, opciones));
            switch (op) {
                case 1:
                    PaisController consoleAdapter = new PaisController();
                    consoleAdapter.mainMenu();
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Suerte no vemos.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Error opcion invalida.");
                    break;
            }

        } while(op!=2);
    }
}