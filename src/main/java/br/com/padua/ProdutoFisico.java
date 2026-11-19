package br.com.padua;

/*
 * PRODUTO FÍSICO (aula 09)
 *
 * Produto físico tem peso e, por isso, tem FRETE. A regra de estoque da
 * mãe já serve (estoque real). A filha SOBRESCREVE só o frete.
 *
 * Quem chama calcularFrete() não precisa saber o tipo do produto:
 *
 *   Produto p = ...;          // pode ser físico ou digital
 *   p.calcularFrete();        // o Java roda a versão do objeto de verdade
 *
 * Isso é POLIMORFISMO.
 */
public class ProdutoFisico extends Produto {

    private Double pesoKg;

    public ProdutoFisico(Integer id, String nome, Double preco, Integer estoque, Categoria categoria, Double pesoKg) {
        super(id, nome, preco, estoque, categoria);
        this.pesoKg = pesoKg;
    }

    public Double getPesoKg() {
        return pesoKg;
    }

    // Regra didática: R$ 10,00 fixos + R$ 2,00 por kg (por unidade).
    @Override
    public Double calcularFrete() {
        return 10.0 + 2.0 * pesoKg;
    }
}
