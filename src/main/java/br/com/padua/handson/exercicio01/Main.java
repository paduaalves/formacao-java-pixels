package br.com.padua.handson.exercicio01;

/*
 * Exercício 1 · Garrafa de água inteligente.
 * Na IDE: abra este arquivo e clique em Run (seta verde ao lado do main).
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== Etapa 1: objetos e variáveis ===");
        Garrafa garrafaAna = new Garrafa("Ana", 500);
        Garrafa garrafaBruno = new Garrafa("Bruno", 750);
        garrafaAna.exibirStatus();
        garrafaBruno.exibirStatus();

        Integer capacidadeTotal = garrafaAna.getCapacidadeMl()
                + garrafaBruno.getCapacidadeMl();
        System.out.println("Capacidade das duas garrafas: " + capacidadeTotal + " ml");

        System.out.println("=== Etapa 2: métodos com regras ===");
        garrafaAna.encher();
        garrafaAna.beber(200);
        garrafaAna.beber(250);
        garrafaAna.beber(100);
        garrafaAna.exibirStatus();

        // Com private, a "trapaça" não compila mais:
        // garrafaBruno.nivelMl = 5000;   // erro: nivelMl has private access
        garrafaBruno.exibirStatus();

        System.out.println("=== Etapa 3: encapsulamento ===");
        garrafaBruno.beber(-300);
        garrafaBruno.setMetaDiariaMl(100000);
        garrafaBruno.setMetaDiariaMl(2500);
        System.out.println("Meta do Bruno: " + garrafaBruno.getMetaDiariaMl() + " ml");

        System.out.println("=== Etapa 4: meta do dia ===");
        garrafaBruno.encher();
        garrafaBruno.beber(750);
        garrafaBruno.encher();
        garrafaBruno.beber(750);
        garrafaBruno.exibirResumoDoDia();
        System.out.println("Bruno bateu a meta? " + garrafaBruno.metaAtingida());

        garrafaBruno.encher();
        garrafaBruno.beber(750);
        garrafaBruno.beber(250);
        garrafaBruno.encher();
        garrafaBruno.beber(250);
        garrafaBruno.exibirResumoDoDia();
        System.out.println("Bruno bateu a meta? " + garrafaBruno.metaAtingida());

        garrafaAna.exibirResumoDoDia();
    }
}
