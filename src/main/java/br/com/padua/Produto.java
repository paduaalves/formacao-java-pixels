package br.com.padua;

/*
 * PRODUTO (versão da aula 07)
 *
 * O que mudou em relação à versão das aulas 05/06:
 *
 * 1. Encapsulamento (aula 06): os atributos agora são private.
 *    Ninguém fora da classe escreve produto.preco = -1500.0.
 *    A leitura é feita por getters e a escrita por setters com validação
 *    ou por métodos de regra de negócio (baixarEstoque).
 *
 * 2. Associação (aula 07): categoria deixou de ser String e passou a ser
 *    um objeto Categoria. Produto "tem uma" referência para Categoria.
 */
public class Produto {

    private Integer id;
    private String nome;
    private Double preco;
    private Integer estoque;

    // ASSOCIAÇÃO: o tipo do atributo é outra classe criada por nós.
    private Categoria categoria;

    // Construtor vazio mantido, como na aula 05.
    public Produto() {
    }

    // O último parâmetro agora é um objeto Categoria, não um texto.
    public Produto(Integer id, String nome, Double preco, Integer estoque, Categoria categoria) {
        this.id = id;
        this.nome = nome;
        setPreco(preco);       // reaproveita a validação do setter
        this.estoque = estoque;
        this.categoria = categoria;
    }

    // ---------- GETTERS: leitura segura ----------

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    // ---------- SETTERS: escrita protegida ----------

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(Double preco) {
        if (preco == null || preco < 0) {
            System.out.println("Preço inválido para " + this.nome + ". Valor recusado: " + preco);
            return;
        }
        this.preco = preco;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    /*
     * Não existe setEstoque de propósito (slide "Regras de Negócio" da
     * aula 06): o estoque só muda por ações com regra.
     */
    public Boolean temEstoque(Integer quantidade) {
        return quantidade != null && quantidade > 0 && this.estoque != null && quantidade <= this.estoque;
    }

    public void baixarEstoque(Integer quantidade) {
        if (!temEstoque(quantidade)) {
            System.out.println("Saldo insuficiente de " + this.nome + ".");
            return;
        }
        this.estoque -= quantidade;
    }

    public void reporEstoque(Integer quantidade) {
        if (quantidade == null || quantidade <= 0) {
            System.out.println("Quantidade de reposição inválida.");
            return;
        }
        this.estoque += quantidade;
    }

    // Mesma regra da aula 05. Agora altera o preço DE CATÁLOGO do produto.
    public void aplicarDesconto(Double percentual) {
        if (percentual == null || percentual < 0 || percentual > 100 || this.preco == null) {
            System.out.println("Desconto não aplicado em " + this.nome + ".");
            return;
        }
        this.preco = this.preco * (1 - percentual / 100.0);
        System.out.println("Desconto de " + percentual + "% em " + this.nome + ". Preço atual: " + this.preco);
    }
}
