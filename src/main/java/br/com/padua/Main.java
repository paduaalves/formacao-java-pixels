package br.com.padua;

/*
 * AULA 07 - Associação, composição e relacionamento entre objetos.
 * Carrinho (escolha, mutável) -> finalizarCompra() -> Pedido (registro, imutável).
 * Roteiro do live coding, na mesma ordem em que aparece no Main.
 */
public class Main {
    public static void main(String[] args) {

        // 1. ASSOCIAÇÃO Produto -> Categoria: categorias existem antes dos produtos.
        Categoria eletronicos = new Categoria(1, "Eletrônicos");
        Categoria livros = new Categoria(2, "Livros");

        Produto mouse = new Produto(1, "Mouse sem fio", 80.0, 10, eletronicos);
        Produto teclado = new Produto(2, "Teclado mecânico", 250.0, 5, eletronicos);
        Produto livroJava = new Produto(3, "Livro Java para Iniciantes", 120.0, 3, livros);

        System.out.println(mouse.getNome() + " está em " + mouse.getCategoria().getNome());
        eletronicos.setNome("Informática");
        System.out.println(mouse.getNome() + " agora está em " + mouse.getCategoria().getNome());
        System.out.println(teclado.getNome() + " agora está em " + teclado.getCategoria().getNome());
        System.out.println("Mesma categoria? " + (mouse.getCategoria() == teclado.getCategoria()));

        // 2. Carrinho -> Cliente (associação) e Carrinho <>-- ItemCarrinho (composição)
        Cliente ana = new Cliente(1, "Ana", "ana@email.com", "85999999999", "Rua A, 10", "12345678900");
        Carrinho carrinho = new Carrinho(ana);
        carrinho.adicionar(mouse, 2);
        carrinho.adicionar(livroJava, 1);
        carrinho.adicionar(mouse, 1);          // mesmo produto: soma a quantidade
        carrinho.adicionar(livroJava, 10);     // estoque insuficiente
        carrinho.imprimirResumo();

        // 3. Preço VIVO: o carrinho acompanha o preço atual do catálogo.
        mouse.setPreco(90.0);
        System.out.println("A loja mudou o mouse para R$ 90.00");
        carrinho.imprimirResumo();

        // 4. Carrinho é mutável: alterar quantidade, remover, voltar.
        carrinho.alterarQuantidade(mouse, 2);
        carrinho.remover(livroJava);
        carrinho.adicionar(livroJava, 1);

        // 5. Desconto no carrinho NÃO altera o catálogo (o bug da aula 05).
        carrinho.aplicarDesconto(10.0);
        carrinho.imprimirResumo();
        System.out.println("Preço do livro no catálogo continua: " + livroJava.getPreco());

        // 6. finalizarCompra: Carrinho vira Pedido (snapshot + baixa de estoque).
        System.out.println("Estoque do mouse antes: " + mouse.getEstoque());
        Pedido pedido = carrinho.finalizarCompra();
        pedido.imprimirResumo();
        System.out.println("Estoque do mouse depois: " + mouse.getEstoque());
        carrinho.imprimirResumo();

        // 7. Snapshot: o preço mudou de novo, o pedido NÃO muda.
        mouse.setPreco(150.0);
        System.out.println("A loja mudou o mouse para R$ 150.00");
        System.out.println("Total do pedido continua: R$ " + String.format("%.2f", pedido.calcularTotal()));

        // 8. Pedido fechado é imutável: a tentativa lança exceção.
        try {
            pedido.adicionarItem(teclado, 1);
        } catch (IllegalStateException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // 9. Carrinho vazio não finaliza; o mesmo carrinho serve para outra compra.
        carrinho.finalizarCompra();
        carrinho.adicionar(teclado, 1);
        Pedido pedido2 = carrinho.finalizarCompra();
        pedido2.imprimirResumo();
        System.out.println(ana.getNome() + " continua existindo, com e-mail " + ana.getEmail());

        // Não compila (descomente em aula para mostrar o erro):
        // mouse.preco = -1500.0;   // error: preco has private access in Produto
    }
}
