package br.com.padua;

/*
 * CARTÃO DE CRÉDITO: até 3x sem juros; de 4x a 6x, 5% de juros no total;
 * acima de 6x, recusado. Guardamos só os 4 últimos dígitos.
 */
public class PagamentoCartao implements Pagamento {

    private String ultimosDigitos;
    private Integer parcelas;

    public PagamentoCartao(String ultimosDigitos, Integer parcelas) {
        this.ultimosDigitos = ultimosDigitos;
        this.parcelas = parcelas;
    }

    @Override
    public String getNome() {
        return "Cartão de crédito";
    }

    @Override
    public Double calcularValorFinal(Double valor) {
        if (parcelas != null && parcelas > 3) {
            return valor * 1.05;   // juros de 5% no total
        }
        return valor;
    }

    @Override
    public Boolean processar(Double valorFinal) {
        if (parcelas == null || parcelas < 1 || parcelas > 6) {
            System.out.println("Cartão final " + ultimosDigitos + " recusado: parcelas de 1 a 6.");
            return false;
        }
        System.out.println("Cartão final " + ultimosDigitos + " aprovado: " + parcelas + "x de R$ "
                + String.format("%.2f", valorFinal / parcelas));
        return true;
    }
}
