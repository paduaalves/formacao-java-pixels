package br.com.padua.handson.exercicio02;

/*
 * EXERCÍCIO 2 · CONSULTÓRIO MÉDICO
 * Paciente existe sozinho: pode ter várias consultas (associação).
 * Telefone tem setter com validação (11 dígitos: DDD + número).
 */
public class Paciente {

    private String nome;
    private String telefone;

    public Paciente(String nome, String telefone) {
        this.nome = nome;
        setTelefone(telefone);
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        if (telefone == null || telefone.length() != 11) {
            System.out.println("Telefone inválido para " + nome + ": " + telefone
                    + " (use DDD + 9 dígitos).");
            return;
        }
        this.telefone = telefone;
    }

    public void exibir() {
        System.out.println("Paciente: " + nome + " | tel. " + telefone);
    }
}
