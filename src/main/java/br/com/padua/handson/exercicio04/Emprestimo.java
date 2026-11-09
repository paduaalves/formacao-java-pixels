package br.com.padua.handson.exercicio04;

/* ASSOCIAÇÃO: recebe um Livro e um Leitor que já existem. */
public class Emprestimo {
    // Estes atributos guardam referências aos objetos recebidos,
    // não cópias do livro e do leitor.
    private Livro livro;
    private Leitor leitor;
    private String status;

    // O construtor associa objetos que foram criados antes do empréstimo.
    public Emprestimo(Livro livro, Leitor leitor) {
        // O objeto existe mesmo se a tentativa for recusada.
        // Neste caso, ele fica com status NÃO REALIZADO, sem reservar o livro.
        this.livro = livro;
        this.leitor = leitor;
        this.status = "NÃO REALIZADO";

        // null indica ausência de objeto; || significa "ou".
        if (livro == null || leitor == null) {
            System.out.println("Informe livro e leitor.");
            return;
        }
        // Tenta reservar o livro. Se o método retornar false, recusa.
        if (!livro.emprestar()) {
            System.out.println("Livro já emprestado: " + livro.getTitulo());
            return;
        }
        this.status = "ATIVO";
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
        // Só um empréstimo ativo pode liberar o livro.
        // return encerra o método quando a operação não é permitida.
        if (!status.equals("ATIVO")) {
            System.out.println("Não dá para devolver: empréstimo " + status + ".");
            return;
        }
        livro.devolver();
        status = "DEVOLVIDO";
        System.out.println("Livro devolvido: " + livro.getTitulo());
    }

    public void exibirResumo() {
        // Uma tentativa com dados ausentes também pode ser exibida com segurança.
        if (livro == null || leitor == null) {
            System.out.println("Empréstimo " + status + ".");
            return;
        }
        System.out.println(livro.getTitulo() + " | " + leitor.getNome()
                + " | " + status);
    }
}
