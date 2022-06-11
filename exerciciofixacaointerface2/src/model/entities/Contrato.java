package model.entities;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contrato {

    private Integer numConta;
    private Date dataContrato;
    private Double valorTotalContrato;
    private List<Parcela> listParcelas = new ArrayList<>();

    public Contrato() {
    }

    public Contrato(Integer numConta, Date dataContrato, Double valorTotalContrato) {
        this.numConta = numConta;
        this.dataContrato = dataContrato;
        this.valorTotalContrato = valorTotalContrato;
    }

    public Integer getNumConta() {
        return numConta;
    }

    public void setNumConta(Integer numConta) {
        this.numConta = numConta;
    }

    public Date getDataContrato() {
        return dataContrato;
    }

    public void setDataContrato(Date dataContrato) {
        this.dataContrato = dataContrato;
    }

    public Double getValorTotalContrato() {
        return valorTotalContrato;
    }

    public void setValorTotalContrato(Double valorTotalContrato) {
        this.valorTotalContrato = valorTotalContrato;
    }

    public List<Parcela> getListParcelas() {
        return listParcelas;
    }
}
