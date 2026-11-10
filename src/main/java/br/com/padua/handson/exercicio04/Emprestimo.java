package br.com.padua.handson.exercicio04;

/* O Leitor cria o empréstimo e o guarda em sua lista: composição.
 * O livro é recebido pronto e pode existir sem o empréstimo: associação.
 */
public class Emprestimo {
    private Livro livro;
    private String status;

    // Sem public: o leitor cria o empréstimo depois de validar as regras.
    Emprestimo(Livro livro) {
        this.livro = livro;
        this.status = "ABERTO";
        // Ao nascer, o empréstimo torna o livro indisponível.
        livro.marcarComoIndisponivel();
    }

    public boolean estaAberto() {
        // equals compara o conteúdo dos textos.
        return status.equals("ABERTO");
    }

    public void encerrar() {
        if (!estaAberto()) {
            System.out.println("Empréstimo já encerrado.");
            return;
        }
        status = "ENCERRADO";
        livro.marcarComoDisponivel();
        System.out.println("Livro devolvido: " + livro.getTitulo());
    }

    public void exibir() {
        System.out.println("  " + livro.getTitulo() + " | " + status);
    }
}
