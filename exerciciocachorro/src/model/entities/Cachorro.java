package model.entities;

public class Cachorro {

        private static Integer numCachorros = 0;
        private static Integer totalFilhotes = 0;

        private String nome;
        private Integer idade;
        private Integer numfilhotes = 0;

    public Cachorro() {
        Cachorro.numCachorros += 1;
        this.nome = "caramelo";
        this.idade = 1;
    }

    public Cachorro(String nome, Integer idade) {
        Cachorro.numCachorros += 1;
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Integer getNumfilhotes() {
        return numfilhotes;
    }

    public void setNumfilhotes(Integer numfilhotes) {
        this.numfilhotes = numfilhotes;
    }

    public void reproduz(){
        this.numfilhotes += 1;
        Cachorro.totalFilhotes += 1;
        System.out.printf("%s acabou de gerar um filhote!", nome);
    }

    public void reproduz(int filhotes){
        numfilhotes += filhotes;
        Cachorro.totalFilhotes += filhotes;
        System.out.printf("%s acabou de gerar %d filhotes!", nome, filhotes);
    }

    @Override
    public String toString() {
        return "O cachorro " + nome + ", possui " + idade + " anos de idade e possui " + numfilhotes + " filhotes.";
    }

    public static void infoCanil(){
        System.out.println("O canil possui um total de " + numCachorros + " cachorros e " + totalFilhotes + " de filhotes");
    }
}
