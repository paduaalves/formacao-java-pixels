package br.com.padua.handson.exercicio03;

/*
 * Exercício 3 · Boletim escolar.
 * Na IDE: abra este arquivo e clique em Run (seta verde ao lado do main).
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== Etapa 1: a nota se protege ===");
        Nota matematica = new Nota("Matemática", 7.5);
        matematica.exibir();
        matematica.setValor(12.0);
        matematica.setValor(8.0);
        matematica.exibir();

        Nota portugues = new Nota("Português", -1.0);
        portugues.exibir();

        System.out.println("=== Etapa 2: o boletim cria as notas ===");
        Aluno lucas = new Aluno("Lucas Lima", "2026001");
        Boletim bimestre1 = new Boletim(lucas, "1º bimestre");
        bimestre1.adicionarNota("Matemática", 4.0);
        bimestre1.adicionarNota("Português", 8.0);
        bimestre1.adicionarNota("Ciências", 6.0);
        bimestre1.adicionarNota("História", 11.0);
        bimestre1.exibir();

        System.out.println("=== Etapa 3: média e situação ===");
        bimestre1.adicionarNota("Matemática", 9.0);
        bimestre1.exibir();
        Boolean aprovado = bimestre1.situacao().equals("APROVADO");
        System.out.println("Lucas passou direto? " + aprovado);

        System.out.println("=== Etapa 4: recuperação e 2º bimestre ===");
        bimestre1.alterarNota("Matemática", 7.0);
        bimestre1.alterarNota("Geografia", 8.0);
        bimestre1.exibir();

        Boletim bimestre2 = new Boletim(lucas, "2º bimestre");
        bimestre2.adicionarNota("Matemática", 8.5);
        bimestre2.adicionarNota("Português", 9.5);
        bimestre2.adicionarNota("Ciências", 7.5);
        bimestre2.exibir();

        Double mediaGeral = (bimestre1.media() + bimestre2.media()) / 2;
        System.out.println("Média dos dois bimestres: " + mediaGeral);
        Boolean mesmoAluno = bimestre1.getAluno() == bimestre2.getAluno();
        System.out.println("Os dois boletins são do mesmo Lucas? " + mesmoAluno);
    }
}
