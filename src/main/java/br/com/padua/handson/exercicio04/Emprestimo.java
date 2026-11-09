package br.com.padua.handson.exercicio04;

/* ASSOCIAÇÃO: recebe um Livro e um Leitor que já existem. */
public class Emprestimo {
    private Livro livro;
    private Leitor leitor;
    private boolean ativo;

    public Emprestimo(Livro livro, Leitor leitor) {
        if (livro == null || leitor == null) {
            throw new IllegalArgumentException("Informe livro e leitor.");
        }
        if (!livro.emprestar()) {
            throw new IllegalStateException("Livro já emprestado: " + livro.getTitulo());
        }
        this.livro = livro;
        this.leitor = leitor;
        this.ativo = true;
    }

    public Livro getLivro() {
        return livro;
    }

    public Leitor getLeitor() {
        return leitor;
    }

    public void devolver() {
        if (!ativo) {
            System.out.println("Empréstimo já devolvido.");
            return;
        }
        livro.devolver();
        ativo = false;
        System.out.println("Livro devolvido: " + livro.getTitulo());
    }

    public void exibirResumo() {
        System.out.println(livro.getTitulo() + " | " + leitor.getNome()
                + " | " + (ativo ? "ATIVO" : "DEVOLVIDO"));
    }
}
