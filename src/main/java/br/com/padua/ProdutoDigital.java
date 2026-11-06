package br.com.padua;

/*
 * PRODUTO DIGITAL (novo na aula 08)
 *
 * Um e-book ou um curso online É UM Produto: tem id, nome, preço e
 * categoria, entra no carrinho e no pedido como qualquer outro.
 * A diferença está no ESTOQUE: arquivo digital não acaba.
 *
 * Por isso a filha SOBRESCREVE (@Override) dois métodos da mãe:
 *
 *   temEstoque    -> sempre há estoque (basta a quantidade ser válida)
 *   baixarEstoque -> não baixa nada; libera o download
 *
 * Carrinho e Pedido NÃO mudaram: eles chamam produto.temEstoque(...)
 * e produto.baixarEstoque(...), e o Java executa a versão do objeto
 * de verdade (a de ProdutoDigital). Isso é assunto da aula 09
 * (polimorfismo); hoje basta ver que funciona.
 */
public class ProdutoDigital extends Produto {

    private String linkDownload;

    // Produto digital não tem estoque físico: passamos 0 para a mãe.
    public ProdutoDigital(Integer id, String nome, Double preco, Categoria categoria, String linkDownload) {
        super(id, nome, preco, 0, categoria);
        this.linkDownload = linkDownload;
    }

    public String getLinkDownload() {
        return linkDownload;
    }

    @Override
    public Boolean temEstoque(Integer quantidade) {
        return quantidade != null && quantidade > 0;
    }

    @Override
    public void baixarEstoque(Integer quantidade) {
        System.out.println("Download de " + getNome() + " liberado: " + linkDownload);
    }
}
