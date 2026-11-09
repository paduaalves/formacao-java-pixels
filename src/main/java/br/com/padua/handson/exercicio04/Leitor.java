package br.com.padua.handson.exercicio04;

/* O leitor existe sozinho e pode participar de vários empréstimos. */
public class Leitor {
    private String nome;
    private String matricula;

    public Leitor(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void exibir() {
        System.out.println("Leitor: " + nome + " | matrícula " + matricula);
    }
}
