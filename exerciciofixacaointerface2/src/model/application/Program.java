package model.application;

import model.entities.Contrato;
import model.entities.Parcela;
import model.service.PagSeguro;
import model.service.Paypal;
import model.service.ServicoContrato;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Preencha os dados do contrato");
        System.out.print("Numero do contrato: ");
        int numContrato = sc.nextInt();
        System.out.print("Data do contrato (dd/mm/yyyy): ");
        Date dataContrato = sdf.parse(sc.next());
        System.out.print("Valor do contrato: ");
        double valorTotalContrato = sc.nextDouble();

        Contrato contrato = new Contrato(numContrato, dataContrato, valorTotalContrato);

        System.out.print("Digite o numero das parcelas: ");
        int mes = sc.nextInt();

        ServicoContrato servicoContrato = new ServicoContrato(contrato, new Paypal(), mes);
        ServicoContrato servicoContrato2 = new ServicoContrato(contrato, new PagSeguro(), mes); // Somente pra exemplificar o uso da interface

        servicoContrato.geradorParcelas();

        System.out.println("Dados das parcelas: ");
        for (Parcela p : contrato.getListParcelas()) {
            System.out.println(p);
        }

    }
}
