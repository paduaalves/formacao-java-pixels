package br.com.padua.handson.exercicio03;

/*
 * EXERCÍCIO 3 · BOLETIM ESCOLAR
 * Aluno existe sozinho e pode ter vários boletins (associação).
 */
public class Aluno {

    private String nome;
    private String matricula;

    public Aluno(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }
}
