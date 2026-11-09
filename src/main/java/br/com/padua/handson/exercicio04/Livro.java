package br.com.padua.handson.exercicio04;

/* EXERCÍCIO 4 · BIBLIOTECA
 * Livro existe independentemente de um empréstimo. Sua disponibilidade
 * só muda pelas operações usadas pelo empréstimo.
 */
public class Livro {
    private String titulo;
    private String autor;
    private boolean disponivel;

    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = true;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    boolean emprestar() {
        if (!disponivel) {
            return false;
        }
        disponivel = false;
        return true;
    }

    void devolver() {
        disponivel = true;
    }

    public void exibir() {
        System.out.println("Livro: " + titulo + " | " + autor
                + " | " + (disponivel ? "DISPONÍVEL" : "EMPRESTADO"));
    }
}
