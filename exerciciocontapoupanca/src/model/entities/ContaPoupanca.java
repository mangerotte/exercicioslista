package model.entities;

import model.exceptions.DomainException;

public class ContaPoupanca {

    private static Integer numContas = 0;
    private static Double totalDinheiro = 0.0;

    private String titular;
    private Double saldo = 0.00;

    public ContaPoupanca(String titular) {
        if (titular == null || titular.isEmpty()){
            throw new DomainException("Por favor utilize um nome válido!");
        }
        ContaPoupanca.numContas += 1;
        this.titular = titular;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    @Override
    public String toString() {
        return "ContaPoupanca: \n" +
                "Titular: " + titular +
                ", Saldo conta: R$ " + String.format("%.2f", saldo);
    }

    public static void infoBanco(){
        System.out.printf("Numero total de contas: %d, Valor Total de dinheiro: R$ %.2f", numContas, totalDinheiro);
    }

    public void saque(double amount){
        if (amount < 0){
            throw new DomainException("O valor de saque não pode ser negativo!");
        }
        if (amount > saldo){
            throw new DomainException("Saldo insuficiente!");
        }
        ContaPoupanca.totalDinheiro -= amount;
        saldo -= amount;
    }

    public void deposit(double amount){
        if (amount < 0){
            throw new DomainException("O valor de deposito tem que ser maior que R$ 0.00");
        }
        ContaPoupanca.totalDinheiro += amount;
        saldo += amount;
    }

}
