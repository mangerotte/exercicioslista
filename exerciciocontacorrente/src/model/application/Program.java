package model.application;

import model.entities.ContaCorrente;
import model.exceptions.DomainException;

public class Program {

    public static void main(String[] args) {

       try {
           ContaCorrente c1 = new ContaCorrente("Luiz", 500.00);
           ContaCorrente c2 = new ContaCorrente("Maria", 100.00);

           c1.deposito(500.00);
           c1.saque(200.00);
           c1.geraExtrato();
           System.out.println(c1);
           c1.saque(300.00);
           System.out.println(c1);
           System.out.println("------------------------");
           c2.deposito(300.00);
           c2.saque(200.00);
           c2.deposito(800.00);
           c2.geraExtrato();
           System.out.println(c2);
           c2.saque(300.00);
           System.out.println(c2);
           System.out.println("------------------------");
           ContaCorrente.geraExtratoBanco();

       }
       catch (DomainException e){
           System.out.println("Erro: " + e.getMessage());
       }
    }
}
