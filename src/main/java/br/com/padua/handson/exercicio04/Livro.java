package br.com.padua.handson.exercicio04;

/* EXERCÍCIO 4 · BIBLIOTECA
 * Livro existe independentemente de um empréstimo. Sua disponibilidade
 * só muda pelas operações usadas pelo empréstimo.
 */
public class Livro {
    // private impede que outras classes alterem os atributos diretamente.
    private String titulo;
    private String autor;
    private boolean disponivel;

    // O construtor é executado quando usamos new Livro(...).
    public Livro(String titulo, String autor) {
        // this.titulo é o atributo; titulo é o valor recebido como parâmetro.
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = true;
    }

    // Um getter permite consultar um atributo privado.
    public String getTitulo() {
        return titulo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    // Sem public, o método só pode ser usado dentro deste pacote.
    // Retorna true se conseguir reservar o livro para um empréstimo.
    boolean emprestar() {
        // ! significa "não": se não estiver disponível, recusa.
        if (!disponivel) {
            return false;
        }
        disponivel = false;
        return true;
    }

    // O empréstimo chama este método ao ser devolvido.
    void devolver() {
        disponivel = true;
    }

    // void indica que o método realiza uma ação sem retornar um valor.
    public void exibir() {
        System.out.println("Livro: " + titulo + " | " + autor
                + " | " + (disponivel ? "DISPONÍVEL" : "EMPRESTADO"));
    }
}
