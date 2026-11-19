package br.com.padua;

/*
 * PAGAMENTO (aula 09): uma INTERFACE.
 *
 * Interface é um CONTRATO: lista o que toda forma de pagamento sabe
 * fazer, sem dizer COMO. Cada forma (Pix, cartão, boleto) assina o
 * contrato com "implements" e escreve o seu jeito.
 *
 *   Pagamento (contrato)
 *      ^  implements
 *      |-- PagamentoPix
 *      |-- PagamentoCartao
 *      |-- PagamentoBoleto
 *
 * O Pedido só conhece o contrato: pedido.pagar(Pagamento pagamento).
 * Amanhã entra uma forma nova e o Pedido não muda uma linha.
 *
 * Os métodos da interface são public e abstract automaticamente
 * (não precisa escrever).
 *
 * Classe abstrata x interface:
 *   - abstract class: "é um" + código compartilhado (Usuario, Item)
 *   - interface: "sabe fazer" + só o contrato (Pagamento)
 */
public interface Pagamento {

    // Nome para mostrar ao cliente ("Pix", "Cartão de crédito"...).
    String getNome();

    // Quanto o cliente realmente paga: desconto do Pix, juros do cartão...
    Double calcularValorFinal(Double valor);

    // Tenta cobrar. true = aprovado, false = recusado.
    Boolean processar(Double valorFinal);
}
