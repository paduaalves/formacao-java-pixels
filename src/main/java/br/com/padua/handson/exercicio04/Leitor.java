package br.com.padua.handson.exercicio04;

/* O leitor existe sozinho e pode participar de vários empréstimos. */
public class Leitor {
    // Cada objeto Leitor guarda seus próprios dados.
    // private protege os atributos contra alterações diretas externas.
    private String nome;
    private String matricula;

    // O construtor recebe os dados usados na criação do objeto.
    public Leitor(String nome, String matricula) {
        // this.nome identifica o atributo deste objeto.
        this.nome = nome;
        this.matricula = matricula;
    }

    // O empréstimo usa este getter para consultar o nome do leitor.
    public String getNome() {
        return nome;
    }

    // Exibe os dados sem precisar acessar os atributos de fora da classe.
    public void exibir() {
        System.out.println("Leitor: " + nome + " | matrícula " + matricula);
    }
}
