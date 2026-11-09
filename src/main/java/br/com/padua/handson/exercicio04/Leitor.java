package br.com.padua.handson.exercicio04;

import java.util.ArrayList;
import java.util.List;

/* O leitor cria e guarda seus empréstimos e só pode ter um aberto. */
public class Leitor {
    private String nome;
    private String matricula;
    // A lista é privada: as operações passam pelos métodos do leitor.
    private List<Emprestimo> emprestimos;

    public Leitor(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
        // Cada leitor começa com sua própria lista vazia.
        this.emprestimos = new ArrayList<>();
    }

    public void alugarLivro(Livro livro) {
        if (livro == null) {
            System.out.println("Informe um livro.");
            return;
        }
        if (buscarEmprestimoAberto() != null) {
            System.out.println(nome + " já possui um empréstimo aberto.");
            return;
        }
        if (!livro.isDisponivel()) {
            System.out.println("Livro indisponível: " + livro.getTitulo());
            return;
        }
        // Composição: o empréstimo nasce aqui e fica na lista do leitor.
        Emprestimo emprestimo = new Emprestimo(livro);
        emprestimos.add(emprestimo);
        System.out.println(nome + " alugou " + livro.getTitulo() + ".");
    }

    public void devolverLivro() {
        Emprestimo aberto = buscarEmprestimoAberto();
        if (aberto == null) {
            System.out.println(nome + " não possui empréstimo aberto.");
            return;
        }
        // O próprio empréstimo muda seu status e libera o livro.
        aberto.encerrar();
    }

    private Emprestimo buscarEmprestimoAberto() {
        // for percorre os empréstimos guardados na lista.
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.estaAberto()) {
                return emprestimo;
            }
        }
        // null indica que nenhum empréstimo aberto foi encontrado.
        return null;
    }

    public void exibir() {
        System.out.println("Leitor: " + nome + " | matrícula " + matricula);
        for (Emprestimo emprestimo : emprestimos) {
            emprestimo.exibir();
        }
    }
}
