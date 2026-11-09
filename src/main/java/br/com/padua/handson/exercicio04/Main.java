package br.com.padua.handson.exercicio04;

/* Exercício 4 · Biblioteca. Abra este arquivo e execute o main na IDE. */
public class Main {
    // A execução do programa começa neste método.
    public static void main(String[] args) {
        System.out.println("=== Etapa 1: livro e leitor ===");
        // new cria um objeto; a variável guarda uma referência para ele.
        Livro livro = new Livro("O Pequeno Príncipe", "Antoine de Saint-Exupéry");
        Leitor ana = new Leitor("Ana Souza", "2026001");
        livro.exibir();
        ana.exibir();

        System.out.println("=== Etapa 2: empréstimo associa os objetos ===");
        // Passamos os objetos já criados, não apenas seus nomes.
        Emprestimo primeiro = new Emprestimo(livro, ana);
        primeiro.exibirResumo();
        livro.exibir();

        System.out.println("=== Etapa 3: não emprestar duas vezes ===");
        Leitor bruno = new Leitor("Bruno Lima", "2026002");
        // try/catch permite mostrar a recusa sem interromper o programa.
        try {
            new Emprestimo(livro, bruno);
        } catch (IllegalStateException erro) {
            System.out.println(erro.getMessage());
        }

        System.out.println("=== Etapa 4: devolução e novo empréstimo ===");
        primeiro.devolver(); // libera o livro
        primeiro.devolver(); // demonstra a recusa de uma segunda devolução
        livro.exibir();
        ana.exibir();
        Emprestimo segundo = new Emprestimo(livro, bruno);
        segundo.exibirResumo();
        // == compara se as duas referências apontam para o mesmo objeto.
        System.out.println("Mesmo livro? " + (primeiro.getLivro() == segundo.getLivro()));
    }
}
