package br.com.padua.handson.exercicio01;

/*
 * EXERCÍCIO 1 · GARRAFA DE ÁGUA INTELIGENTE
 * Revisa: variáveis, métodos e encapsulamento.
 *
 * - O nível só muda pelos métodos encher() e beber(): não existe setNivelMl.
 * - A meta diária tem setter, mas com validação (de 500 a 5000 ml).
 * - Os métodos de cálculo usam Integer: 450 * 100 / 2000 dá 22 (divisão inteira).
 */
public class Garrafa {

    private String dono;
    private Integer capacidadeMl;
    private Integer nivelMl;
    private Integer metaDiariaMl;
    private Integer totalBebidoMl;

    public Garrafa(String dono, Integer capacidadeMl) {
        this.dono = dono;
        this.capacidadeMl = capacidadeMl;
        this.nivelMl = 0;
        this.metaDiariaMl = 2000;
        this.totalBebidoMl = 0;
    }

    public String getDono() {
        return dono;
    }

    public Integer getCapacidadeMl() {
        return capacidadeMl;
    }

    public Integer getNivelMl() {
        return nivelMl;
    }

    public Integer getMetaDiariaMl() {
        return metaDiariaMl;
    }

    public Integer getTotalBebidoMl() {
        return totalBebidoMl;
    }

    public void setMetaDiariaMl(Integer metaDiariaMl) {
        if (metaDiariaMl == null || metaDiariaMl < 500 || metaDiariaMl > 5000) {
            System.out.println("Meta inválida: " + metaDiariaMl
                    + " ml (use de 500 a 5000).");
            return;
        }
        this.metaDiariaMl = metaDiariaMl;
    }

    public void encher() {
        nivelMl = capacidadeMl;
        System.out.println(dono + " encheu a garrafa: " + nivelMl + " ml.");
    }

    public void beber(Integer ml) {
        if (ml == null || ml <= 0) {
            System.out.println("Quantidade inválida: " + ml + " ml.");
            return;
        }
        if (ml > nivelMl) {
            System.out.println("Só tem " + nivelMl + " ml na garrafa de " + dono + ".");
            return;
        }
        nivelMl = nivelMl - ml;
        totalBebidoMl = totalBebidoMl + ml;
        System.out.println(dono + " bebeu " + ml + " ml. Restam " + nivelMl + " ml.");
    }

    public Integer percentualDaMeta() {
        return totalBebidoMl * 100 / metaDiariaMl;
    }

    public Boolean metaAtingida() {
        return totalBebidoMl >= metaDiariaMl;
    }

    public void exibirStatus() {
        System.out.println("Garrafa de " + dono + ": " + nivelMl
                + " de " + capacidadeMl + " ml");
    }

    public void exibirResumoDoDia() {
        System.out.println("Resumo de " + dono + ": bebeu " + totalBebidoMl + " de "
                + metaDiariaMl + " ml (" + percentualDaMeta() + "% da meta)");
    }
}
