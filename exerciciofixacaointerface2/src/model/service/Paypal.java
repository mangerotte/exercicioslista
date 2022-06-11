package model.service;

public class Paypal implements ServicoPagamento {

    private double juros = 0.01;
    private double taxa = 0.02;

    @Override
    public double jurosMensal(double valor, int mes) {
        return valor * juros * mes;
    }

    @Override
    public double taxaPagamento(double valor) {
        return valor * taxa;
    }
}
