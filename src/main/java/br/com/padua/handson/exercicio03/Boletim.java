package br.com.padua.handson.exercicio03;

import java.util.ArrayList;
import java.util.List;

/*
 * EXERCÍCIO 3 · BOLETIM ESCOLAR
 * ASSOCIAÇÃO: o boletim RECEBE um Aluno pronto (ele já existia antes).
 * COMPOSIÇÃO: o boletim CRIA as próprias notas (new Nota lá dentro).
 *             A lista é private e não tem getter: ninguém de fora mexe nela.
 */
public class Boletim {

    private Aluno aluno;
    private String periodo;
    private List<Nota> notas;

    public Boletim(Aluno aluno, String periodo) {
        this.aluno = aluno;
        this.periodo = periodo;
        this.notas = new ArrayList<>();
    }

    public Aluno getAluno() {
        return aluno;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void adicionarNota(String disciplina, Double valor) {
        if (buscarNota(disciplina) != null) {
            System.out.println(disciplina + " já está no boletim.");
            return;
        }
        Nota nota = new Nota(disciplina, valor);
        if (nota.getValor() == null) {
            System.out.println(disciplina + " ficou fora do boletim.");
            return;
        }
        notas.add(nota);
    }

    public void alterarNota(String disciplina, Double novoValor) {
        Nota nota = buscarNota(disciplina);
        if (nota == null) {
            System.out.println(disciplina + " não está no boletim.");
            return;
        }
        nota.setValor(novoValor);
        System.out.println("Nota de " + disciplina + " agora é " + nota.getValor() + ".");
    }

    private Nota buscarNota(String disciplina) {
        for (Nota nota : notas) {
            if (nota.getDisciplina().equals(disciplina)) {
                return nota;
            }
        }
        return null;
    }

    public Double media() {
        if (notas.isEmpty()) {
            return 0.0;
        }
        Double soma = 0.0;
        for (Nota nota : notas) {
            soma = soma + nota.getValor();
        }
        return soma / notas.size();
    }

    public String situacao() {
        Double media = media();
        if (media >= 7) {
            return "APROVADO";
        }
        if (media >= 5) {
            return "RECUPERAÇÃO";
        }
        return "REPROVADO";
    }

    public void exibir() {
        System.out.println("Boletim de " + aluno.getNome() + " (" + aluno.getMatricula()
                + ") - " + periodo);
        for (Nota nota : notas) {
            nota.exibir();
        }
        System.out.println("  Média: " + media() + " | Situação: " + situacao());
    }
}
