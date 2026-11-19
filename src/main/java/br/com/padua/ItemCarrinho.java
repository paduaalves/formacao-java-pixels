package br.com.padua;

/*
 * ITEM DO CARRINHO
 *
 * Uma linha do carrinho: "2x Mouse sem fio".
 *
 * Aula 09: agora é FILHA de Item (abstrata). Produto e quantidade
 * moram na mãe. Aqui fica só o que é diferente: o subtotal com o
 * preço VIVO e os métodos que mudam a quantidade.
 *
 * Repare no que NÃO existe aqui: preço guardado. O subtotal sempre
 * pergunta ao produto quanto ele custa AGORA (preço vivo).
 *
 * COMPOSIÇÃO: o item é PARTE do Carrinho. O construtor não é public
 * (acesso de pacote): quem cria o item é o próprio Carrinho, em adicionar.
 */
public class ItemCarrinho extends Item {

    ItemCarrinho(Produto produto, Integer quantidade) {
        super(produto, quantidade);
    }

    // Implementa o método ABSTRATO de Item: preço VIVO.
    @Override
    public Double getSubtotal() {
        return getProduto().getPreco() * getQuantidade();
    }

    // Usados pelo Carrinho (mesmo pacote) para mudar a quantidade.
    void aumentarQuantidade(Integer quantidade) {
        setQuantidade(getQuantidade() + quantidade);
    }

    void definirQuantidade(Integer quantidade) {
        setQuantidade(quantidade);
    }
}
