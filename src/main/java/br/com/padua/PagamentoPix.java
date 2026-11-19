package br.com.padua;

/*
 * PIX: 5% de desconto. Aprovação na hora.
 * "implements Pagamento" = assinou o contrato: é OBRIGADO a escrever
 * os três métodos (sem um deles, o código não compila).
 */
public class PagamentoPix implements Pagamento {

    private String chave;

    public PagamentoPix(String chave) {
        this.chave = chave;
    }

    @Override
    public String getNome() {
        return "Pix";
    }

    @Override
    public Double calcularValorFinal(Double valor) {
        return valor * 0.95;   // 5% de desconto
    }

    @Override
    public Boolean processar(Double valorFinal) {
        System.out.println("Pix de R$ " + String.format("%.2f", valorFinal) + " aprovado (chave " + chave + ").");
        return true;
    }
}
