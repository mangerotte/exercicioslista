package model.service;

public class PagSeguro implements ServicoPagamento{
    private double juros = 0.012;
    private double taxa = 0.05;

    @Override
    public double jurosMensal(double valor, int mes) {
        return valor * juros * mes;
    }

    @Override
    public double taxaPagamento(double valor) {
        return valor * taxa;
    }
}
