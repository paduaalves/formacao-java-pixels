package br.com.padua;

/*
 * ITEM DO CARRINHO
 *
 * Uma linha do carrinho: "2x Mouse sem fio".
 *
 *   produto      ASSOCIAÇÃO: aponta para o Produto do catálogo.
 *   quantidade   quantas unidades o cliente quer levar.
 *
 * Repare no que NÃO existe aqui: preço guardado. O subtotal sempre
 * pergunta ao produto quanto ele custa AGORA (preço vivo). Se a loja
 * mudar o preço enquanto o cliente ainda está escolhendo, o carrinho
 * mostra o preço novo, como em qualquer loja virtual.
 *
 * COMPOSIÇÃO: o item é PARTE do Carrinho. O construtor não é public
 * (acesso de pacote): quem cria o item é o próprio Carrinho, em adicionar.
 */
public class ItemCarrinho {

    private Produto produto;
    private Integer quantidade;

    // Sem public: só o pacote br.com.padua cria itens de carrinho.
    ItemCarrinho(Produto produto, Integer quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    // Preço VIVO: lê o preço do produto no momento da conta.
    public Double getSubtotal() {
        return produto.getPreco() * quantidade;
    }

    // Usados pelo Carrinho (mesmo pacote) para mudar a quantidade.
    void aumentarQuantidade(Integer quantidade) {
        this.quantidade += quantidade;
    }

    void definirQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
