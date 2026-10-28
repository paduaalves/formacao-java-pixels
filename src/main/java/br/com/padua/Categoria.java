package br.com.padua;

/*
 * AULA 07 - ASSOCIAÇÃO
 *
 * Até a aula 06, a categoria do produto era só um texto:
 *     String categoria = "Eletrônicos";
 * Um texto não tem id, não tem regras e pode ser digitado de jeitos
 * diferentes ("Eletronicos", "eletrônicos"...). Agora Categoria vira
 * uma classe própria, e Produto passa a GUARDAR UMA REFERÊNCIA para
 * um objeto Categoria.
 *
 * Isso é ASSOCIAÇÃO: Produto "conhece" uma Categoria.
 * A categoria existe sozinha: ela nasce antes dos produtos e continua
 * existindo mesmo que nenhum produto aponte para ela. Vários produtos
 * podem apontar para a MESMA categoria (relação muitos-para-um).
 */
public class Categoria {

    // Encapsulamento (aula 06): atributos privados, acesso só por métodos.
    private Integer id;
    private String nome;

    public Categoria(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    /*
     * Renomear a categoria muda o que TODOS os produtos associados
     * enxergam, porque eles guardam a referência, não uma cópia do texto.
     */
    public void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            System.out.println("Nome de categoria inválido.");
            return;
        }
        this.nome = nome;
    }
}
