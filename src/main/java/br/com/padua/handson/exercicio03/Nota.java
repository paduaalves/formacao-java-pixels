package br.com.padua.handson.exercicio03;

/*
 * EXERCÍCIO 3 · BOLETIM ESCOLAR
 * Nota é a PARTE da composição: quem cria as notas é o Boletim.
 * O setValor protege a regra: só vale de 0 a 10.
 */
public class Nota {

    private String disciplina;
    private Double valor;

    public Nota(String disciplina, Double valor) {
        this.disciplina = disciplina;
        setValor(valor);
    }

    public String getDisciplina() {
        return disciplina;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        if (valor == null || valor < 0 || valor > 10) {
            System.out.println("Nota inválida para " + disciplina + ": " + valor
                    + " (use de 0 a 10).");
            return;
        }
        this.valor = valor;
    }

    public void exibir() {
        System.out.println("  " + disciplina + ": " + valor);
    }
}
