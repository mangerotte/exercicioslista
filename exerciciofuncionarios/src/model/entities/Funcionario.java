package model.entities;

import model.entities.exception.DomainExceptions;

public class Funcionario {

    private static Double valeRefeicao = 393.0;
    private static Double salarioMinimo = 1212.00;
    private static Double gratificacaoNatalina = 0.083;

    private String nome;
    private Double salario;
    private Double bonificacao;

    public Funcionario(String nome, Double salario, Double bonificacao) {
        if (nome == null || nome.isEmpty() ) {
            throw new DomainExceptions("Por favor digite um nome valido");
        }
        if (salario <= salarioMinimo){
            throw new DomainExceptions("O salario deve ser maior ou igual o salario minimo");
        }
        if (bonificacao < 0){
            throw new DomainExceptions("A bonificação tem que ser maior que zero.");
        }
        this.nome = nome;
        this.salario = salario;
        this.bonificacao = bonificacao;
    }

    public static Double getValeRefeicao() {
        return valeRefeicao;
    }

    public static void setValeRefeicao(Double vale) {
        if (vale < valeRefeicao){
            throw new DomainExceptions("O novo valor do vale refeição não pode ser menor que o atual");
        }
        Funcionario.valeRefeicao = valeRefeicao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double novoSalario) {
        if (novoSalario < salario){
            throw new DomainExceptions("O novo salario não pode ser menor que o atual");
        }
        this.salario = salario;
    }

    public Double getBonificacao() {
        return bonificacao;
    }

    public void setBonificacao(Double bonificacao) {
        this.bonificacao = bonificacao;
    }

    public Double calGanhoMensal(){
        return salario + (salario * (bonificacao / 100)) + valeRefeicao;
    }

    public Double calGanhoAnual(){
        return (calGanhoMensal() * 12) + (calGanhoMensal() * gratificacaoNatalina);
    }

    @Override
    public String toString() {
        return "Dados do funcionario: \n" +
                "Nome: " + nome +
                ", Salario base: " + String.format("%.2f", salario) +
                ", Bonificação: " + bonificacao + "%" +
                ", Salario mensal bruto: " + String.format("%.2f", calGanhoMensal()) +
                ", Salario anual: " + String.format("%.2f", calGanhoAnual()) +
                ", Vale refeição: " + String.format("%.2f", valeRefeicao);
    }
}
