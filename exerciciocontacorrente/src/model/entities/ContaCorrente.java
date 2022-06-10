package model.entities;

import model.exceptions.DomainException;
import org.w3c.dom.DOMException;

public class ContaCorrente {

    private static String historicoBanco = "Operações: \n";
    private static Double tarifa = 1.50;
    private static Integer numContas = 0;
    private static Double saldoTotal = 0.0;

    private String titular;
    private Double saldo = 0.0;
    private String historico = "Operações: \n";
    private Double limite;


    public ContaCorrente(String titular, Double limite) {
        if (titular == null || titular.isEmpty()){
            throw new DomainException("Digite um titular valido!");
        }
        if (limite < 0){
            throw new DomainException("O valor do limite tem que ser maior que zero");
        }
        ContaCorrente.numContas += 1;
        this.titular = titular;
        this.limite = limite;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public Double getSaldo() {
        return saldo;
    }

    public String getHistorico() {
        return historico;
    }

    public Double getLimite() {
        return limite;
    }

    public void setLimite(Double limite) {
        this.limite = limite;
    }

    public static Double getTarifa() {
        return tarifa;
    }

    public static void setTarifa(Double tarifa) {
        ContaCorrente.tarifa = tarifa;
    }

    @Override
    public String toString() {
        return "Dados conta corrente: \n" +
                "Titular: " + titular +
                ", Saldo: R$ " + String.format("%.2f", saldo) +
                ", Limite: R$ " + String.format("%.2f", limite);
    }

    private void registraOperacao(String operacao){
        historico += operacao + "\n";
    }
    private static void registraOperacaoBanco(String operacao, String titular){
        ContaCorrente.historicoBanco += titular + ": " + operacao + "\n";
    }

    private boolean cobraTarifa(){
        if (ContaCorrente.tarifa < saldo){
            saldo -= ContaCorrente.tarifa;
            return true;
        }
        else return false;
    }

    public void saque(Double valor){
        valor += ContaCorrente.tarifa;
        if (valor < 0){
            throw new DomainException("O valor de saque tem que ser maior que zero");
        }
        if (valor > saldo + limite){
            throw new DomainException("Saldo insuficiente");
        }
        saldo -= valor;
        ContaCorrente.saldoTotal -= valor;
        registraOperacao("saque");
        registraOperacaoBanco("saque", getTitular());
    }

    public void deposito(Double valor){
        if (valor < 0){
            throw new DomainException("O valor de deposito tem que ser maior que zero");
        }
        saldo += valor;
        ContaCorrente.saldoTotal += valor;
        registraOperacao("deposito");
        registraOperacaoBanco("deposito", getTitular());
    }

    public void geraExtrato() {
        if (ContaCorrente.tarifa > saldo){
            throw new DomainException("Saldo insuficiente");
        }
        saldo -= ContaCorrente.tarifa;
        registraOperacao("extrato");
        registraOperacaoBanco("extrato", getTitular());
        System.out.println(historico);
    }

    public static void geraExtratoBanco(){
        System.out.println(ContaCorrente.historicoBanco);
    }
}
