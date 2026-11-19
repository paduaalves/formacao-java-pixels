package br.com.padua;

/*
 * BOLETO: taxa fixa de R$ 3,50. Gera o boleto e aprova o pedido
 * (compensação simulada: aqui não esperamos o banco).
 */
public class PagamentoBoleto implements Pagamento {

    @Override
    public String getNome() {
        return "Boleto";
    }

    @Override
    public Double calcularValorFinal(Double valor) {
        return valor + 3.50;   // taxa do boleto
    }

    @Override
    public Boolean processar(Double valorFinal) {
        System.out.println("Boleto de R$ " + String.format("%.2f", valorFinal) + " gerado. Vence em 3 dias.");
        return true;
    }
}
