package br.com.padua.handson.exercicio04;

/* Exercício 4 · Biblioteca. Abra este arquivo e execute o main na IDE. */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Etapa 1: livros e leitores ===");
        // new cria objetos; as variáveis guardam referências para eles.
        Livro principe = new Livro("O Pequeno Príncipe", "Antoine de Saint-Exupéry");
        Livro aventura = new Livro("A Ilha do Tesouro", "Robert Louis Stevenson");
        Leitor ana = new Leitor("Ana Souza", "2026001");
        Leitor bruno = new Leitor("Bruno Lima", "2026002");
        principe.exibir();
        ana.exibir();

        System.out.println("=== Etapa 2: aluguel e recusas ===");
        ana.alugarLivro(principe);
        ana.alugarLivro(aventura); // Ana já tem empréstimo aberto.
        bruno.alugarLivro(principe); // O livro está indisponível.
        principe.exibir();
        ana.exibir();

        System.out.println("=== Etapa 3: devolução e novo aluguel ===");
        ana.devolverLivro();
        ana.devolverLivro(); // Não há mais empréstimo aberto.
        bruno.alugarLivro(principe);
        ana.alugarLivro(aventura); // Ana pode alugar novamente.
        principe.exibir();
        ana.exibir(); // A lista mantém o histórico encerrado e o aberto.
        bruno.exibir();
    }
}
