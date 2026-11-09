package br.com.padua.handson.exercicio04;

/* ASSOCIAÇÃO: recebe um Livro e um Leitor que já existem. */
public class Emprestimo {
    // Estes atributos guardam referências aos objetos recebidos,
    // não cópias do livro e do leitor.
    private Livro livro;
    private Leitor leitor;
    // boolean guarda true (ativo) ou false (devolvido).
    private boolean ativo;

    // O construtor associa objetos que foram criados antes do empréstimo.
    public Emprestimo(Livro livro, Leitor leitor) {
        // null indica ausência de objeto; || significa "ou".
        if (livro == null || leitor == null) {
            // A exceção interrompe a criação com argumentos ausentes.
            throw new IllegalArgumentException("Informe livro e leitor.");
        }
        // Tenta reservar o livro. Se o método retornar false, recusa.
        if (!livro.emprestar()) {
            throw new IllegalStateException("Livro já emprestado: " + livro.getTitulo());
        }
        // Depois das validações, guarda as referências e ativa o empréstimo.
        this.livro = livro;
        this.leitor = leitor;
        this.ativo = true;
    }

    // Os getters permitem consultar quais objetos estão associados.
    public Livro getLivro() {
        return livro;
    }

    public Leitor getLeitor() {
        return leitor;
    }

    // Uma devolução válida libera o livro e encerra este empréstimo.
    public void devolver() {
        // return encerra o método e evita devolver novamente.
        if (!ativo) {
            System.out.println("Empréstimo já devolvido.");
            return;
        }
        livro.devolver();
        ativo = false;
        System.out.println("Livro devolvido: " + livro.getTitulo());
    }

    // O operador ? escolhe o texto de acordo com o valor de ativo.
    public void exibirResumo() {
        System.out.println(livro.getTitulo() + " | " + leitor.getNome()
                + " | " + (ativo ? "ATIVO" : "DEVOLVIDO"));
    }
}
