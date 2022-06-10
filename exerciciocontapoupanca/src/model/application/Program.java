package model.application;

import model.entities.ContaPoupanca;
import model.exceptions.DomainException;

import java.util.Locale;

public class Program {

    public static void main(String[] args) {

        try {
            ContaPoupanca c1 = new ContaPoupanca("Luiz Augusto");
            ContaPoupanca c2 = new ContaPoupanca("Leonardo Mendes");

            c1.deposit(500.50);
            c1.saque(300);
            System.out.println(c1);

            System.out.println();
            c2.deposit(3000);
            c2.saque(230.30);
            System.out.println(c2);

            System.out.println();
            ContaPoupanca.infoBanco();

        } catch (DomainException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
