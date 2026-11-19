package br.com.padua;

/*
 * ITEM (aula 09): classe MÃE ABSTRATA de ItemCarrinho e ItemPedido.
 *
 * Na aula 08 vimos que os dois itens repetem produto e quantidade.
 * O que é comum sobe para cá. Mas o getSubtotal NÃO sobe pronto:
 *
 *   ItemCarrinho -> preço VIVO   (pergunta ao produto agora)
 *   ItemPedido   -> preço COPIADO (valor congelado na compra)
 *
 * Cada filha calcula de um jeito, e a mãe não tem como saber qual.
 * Solução: MÉTODO ABSTRATO. A mãe diz "todo item TEM um subtotal" e
 * obriga as filhas a escreverem a conta.
 *
 * "abstract class": não dá para fazer new Item(...). Um item solto,
 * sem ser do carrinho nem do pedido, não existe na loja.
 */
public abstract class Item {

    private Produto produto;
    private Integer quantidade;

    // Sem public: só o pacote cria itens (as filhas chamam com super).
    Item(Produto produto, Integer quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    // protected: pensado para as FILHAS (ItemCarrinho muda a quantidade).
    protected void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return quantidade + "x " + produto.getNome();
    }

    // MÉTODO ABSTRATO: sem corpo. Cada filha escreve a sua conta.
    public abstract Double getSubtotal();
}
