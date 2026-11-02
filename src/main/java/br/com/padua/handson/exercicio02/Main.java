package br.com.padua.handson.exercicio02;

/*
 * Exercício 2 · Consultório médico.
 * Na IDE: abra este arquivo e clique em Run (seta verde ao lado do main).
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== Etapa 1: paciente e médico ===");
        Paciente ana = new Paciente("Ana Souza", "85999990000");
        Medico helena = new Medico("Dra. Helena Costa", "CRM-CE 12345", "Cardiologia");
        ana.exibir();
        helena.exibir();

        ana.setTelefone("9999");
        ana.exibir();

        System.out.println("=== Etapa 2: a consulta liga os dois ===");
        Medico rafael = new Medico("Dr. Rafael Lima", "CRM-CE 67890", "Dermatologia");
        Consulta consulta1 = new Consulta(ana, helena, "10/11 às 14h");
        Consulta consulta2 = new Consulta(ana, rafael, "12/11 às 9h");
        consulta1.exibirResumo();
        consulta2.exibirResumo();

        System.out.println("=== Etapa 3: status da consulta ===");
        consulta1.realizar("Pressão normal. Retorno em 6 meses.");
        consulta2.cancelar();
        consulta2.realizar("Pele sem alterações.");
        consulta1.cancelar();
        consulta1.exibirResumo();
        consulta2.exibirResumo();

        System.out.println("=== Etapa 4: objetos independentes ===");
        Consulta consulta3 = new Consulta(ana, rafael, "19/11 às 9h");
        consulta3.exibirResumo();
        ana.setTelefone("85988887777");
        consulta3.enviarLembrete();
        consulta2.enviarLembrete();

        Boolean mesmaPaciente = consulta1.getPaciente() == consulta3.getPaciente();
        System.out.println("Consulta 1 e 3 apontam para a mesma Ana? " + mesmaPaciente);
    }
}
