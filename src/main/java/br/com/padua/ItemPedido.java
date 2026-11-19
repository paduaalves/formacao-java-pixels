package br.com.padua;

/*
 * ITEM DO PEDIDO
 *
 * Aula 09: FILHA de Item (abstrata). Produto e quantidade moram na mãe.
 * Aqui fica o que é só do pedido: o precoUnitario COPIADO.
 *
 * ItemCarrinho pergunta o preço ao produto toda vez (preço vivo).
 * ItemPedido copiou o número uma vez e nunca mais pergunta. Se o
 * catálogo mudar amanhã, o pedido de hoje continua igual, como uma
 * nota fiscal.
 *
 * COMPOSIÇÃO: o item é parte do Pedido. Construtor sem public:
 * quem cria é o Pedido, em adicionarItem.
 */
public class ItemPedido extends Item {

    private Double precoUnitario;

    ItemPedido(Produto produto, Integer quantidade) {
        super(produto, quantidade);
        this.precoUnitario = produto.getPreco();   // copia o VALOR, não a referência
    }

    public Double getPrecoUnitario() {
        return precoUnitario;
    }

    // Implementa o método ABSTRATO de Item: usa o preço CONGELADO.
    @Override
    public Double getSubtotal() {
        return precoUnitario * getQuantidade();
    }
}
