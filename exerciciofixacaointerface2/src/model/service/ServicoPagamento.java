package model.service;

public interface ServicoPagamento {

    double jurosMensal(double valor, int mes);
    double taxaPagamento(double valor);
}
