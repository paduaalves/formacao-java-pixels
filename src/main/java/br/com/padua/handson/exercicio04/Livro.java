package br.com.padua.handson.exercicio04;

/* EXERCÍCIO 4 · BIBLIOTECA
 * O livro existe independentemente de seus empréstimos.
 */
public class Livro {
    // private protege os atributos contra alterações diretas de outras classes.
    private String titulo;
    private String autor;
    private boolean disponivel;

    // O construtor é executado ao criar um objeto com new Livro(...).
    public Livro(String titulo, String autor) {
        // this.titulo é o atributo; titulo é o parâmetro recebido.
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = true;
    }

    public String getTitulo() {
        return titulo;
    }

    // boolean retorna true ou false para indicar a disponibilidade.
    public boolean isDisponivel() {
        return disponivel;
    }

    // Sem public, estes métodos são acessíveis dentro deste pacote.
    // O empréstimo os utiliza para atualizar a disponibilidade.
    void marcarComoIndisponivel() {
        disponivel = false;
    }

    void marcarComoDisponivel() {
        disponivel = true;
    }

    public void exibir() {
        System.out.println("Livro: " + titulo + " | " + autor
                + " | " + (disponivel ? "DISPONÍVEL" : "INDISPONÍVEL"));
    }
}
