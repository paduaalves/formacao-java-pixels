package br.com.padua;

/*
 * ITEM DO PEDIDO
 *
 * Parecido com ItemCarrinho, com UMA diferença decisiva:
 *
 *   produto        ASSOCIAÇÃO: aponta para o Produto do catálogo
 *                  (para saber o nome, a categoria, baixar o estoque).
 *   quantidade     quantas unidades foram compradas.
 *   precoUnitario  CÓPIA do preço no momento da compra (snapshot).
 *
 * ItemCarrinho pergunta o preço ao produto toda vez (preço vivo).
 * ItemPedido copiou o número uma vez e nunca mais pergunta. Se o
 * catálogo mudar amanhã, o pedido de hoje continua igual, como uma
 * nota fiscal.
 *
 * COMPOSIÇÃO: o item é parte do Pedido. Construtor sem public:
 * quem cria é o Pedido, em adicionarItem.
 */
public class ItemPedido {

    private Produto produto;
    private Integer quantidade;
    private Double precoUnitario;

    ItemPedido(Produto produto, Integer quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoUnitario = produto.getPreco();   // copia o VALOR, não a referência
    }

    public Produto getProduto() {
        return produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public Double getPrecoUnitario() {
        return precoUnitario;
    }

    // Usa o preço CONGELADO, nunca produto.getPreco().
    public Double getSubtotal() {
        return precoUnitario * quantidade;
    }
}
