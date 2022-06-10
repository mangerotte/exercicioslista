package model.application;

import model.entities.Funcionario;

public class Program {

    public static void main(String[] args) {

        Funcionario f1 = new Funcionario("Alex", 3000.00, 5.5);
        Funcionario f2 = new Funcionario("Maria", 2550.00, 10.5);

        System.out.println(f1);
        System.out.println();
        System.out.println(f2);
    }
}
