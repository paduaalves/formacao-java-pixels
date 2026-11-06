package br.com.padua.handson.exercicio02;

/*
 * EXERCÍCIO 2 · CONSULTÓRIO MÉDICO
 * Médico existe sozinho: atende várias consultas (associação).
 * CRM não tem setter: depois de criado, não muda (encapsulamento).
 */
public class Medico {

    private String nome;
    private String crm;
    private String especialidade;

    public Medico(String nome, String crm, String especialidade) {
        this.nome = nome;
        this.crm = crm;
        this.especialidade = especialidade;
    }

    public String getNome() {
        return nome;
    }

    public String getCrm() {
        return crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void exibir() {
        System.out.println("Médico: " + nome + " | " + crm + " | " + especialidade);
    }
}
