package model.service;

import model.entities.Contrato;
import model.entities.Parcela;

import java.util.Calendar;
import java.util.Date;

public class ServicoContrato {

    private Contrato contrato;
    private ServicoPagamento servicoPagamento;
    private Integer mes;

    public ServicoContrato(Contrato contrato, ServicoPagamento servicoPagamento, Integer mes) {
        this.contrato = contrato;
        this.servicoPagamento = servicoPagamento;
        this.mes = mes;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public ServicoPagamento getServicoPagamento() {
        return servicoPagamento;
    }

    public void setServicoPagamento(ServicoPagamento servicoPagamento) {
        this.servicoPagamento = servicoPagamento;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public void geradorParcelas(){

        for (int i = 1; i <= mes; i++){

            double valorParcela = contrato.getValorTotalContrato() / mes;
            double valorTotalParcela = (valorParcela + servicoPagamento.jurosMensal(valorParcela, i));
            valorTotalParcela += servicoPagamento.taxaPagamento(valorTotalParcela);

            Calendar cal = Calendar.getInstance();
            cal.setTime(contrato.getDataContrato());
            cal.add(Calendar.MONTH, i);
            Date dataVencimento = cal.getTime();

            Parcela parcela = new Parcela(dataVencimento,valorTotalParcela);
            contrato.getListParcelas().add(parcela);
        }
    }
}
