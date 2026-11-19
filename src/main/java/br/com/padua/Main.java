package br.com.padua;

import java.util.ArrayList;
import java.util.List;

/*
 * AULA 09 - Polimorfismo, abstração e interfaces.
 * Roteiro do live coding, na mesma ordem em que aparece no Main.
 * (Continua o código da aula 08: Usuario, Cliente, Administrador,
 * Produto, ProdutoDigital.)
 */
public class Main {
    public static void main(String[] args) {

        // Dados de partida (iguais aos da aula 08).
        Cliente ana = new Cliente(1, "Ana", "ana@email.com", "85999999999", "Rua A, 10", "12345678900");
        Cliente bia = new Cliente(2, "Bia", "bia@email.com", "85988887777", "Av. Beira Mar, 1000", "98765432100");
        Administrador carlos = new Administrador(100, "Carlos", "carlos@loja.com", "Gerente de catálogo");

        Categoria informatica = new Categoria(1, "Informática");
        Categoria livros = new Categoria(2, "Livros");
        Categoria cursos = new Categoria(3, "Cursos online");

        Produto mouse = new Produto(1, "Mouse sem fio", 80.0, 10, informatica);
        Produto livroJava = new Produto(3, "Livro Java para Iniciantes", 120.0, 3, livros);
        ProdutoDigital cursoJava = new ProdutoDigital(4, "Curso Java Online", 199.9, cursos, "https://loja.com/download/curso-java");

        // 1. POLIMORFISMO: uma variável do tipo da MÃE guarda um objeto da FILHA
        //    (upcasting) e a chamada executa a versão do objeto de verdade.
        System.out.println("== 1. Polimorfismo com Usuario ==");
        Usuario u = carlos;                  // Administrador É UM Usuario
        u.exibirDados();                     // roda a versão do Administrador

        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(ana);
        usuarios.add(carlos);
        usuarios.add(bia);
        for (Usuario usuario : usuarios) {   // mesmo código, comportamentos diferentes
            usuario.exibirDados();
        }

        // 2. instanceof: descobrir o tipo de verdade (e usar o que só a filha tem).
        System.out.println("== 2. instanceof ==");
        for (Usuario usuario : usuarios) {
            if (usuario instanceof Administrador admin) {
                admin.reporEstoque(livroJava, 1);          // método SÓ do Administrador
            } else if (usuario instanceof Cliente cliente) {
                System.out.println(cliente.getNome() + " mora em " + cliente.getEndereco());
            }
        }

        // 3. CLASSE ABSTRATA: Usuario não pode ser criado direto,
        //    mas obriga as filhas a implementarem getPerfil().
        System.out.println("== 3. Classe abstrata ==");
        for (Usuario usuario : usuarios) {
            System.out.println(usuario.getNome() + " -> perfil " + usuario.getPerfil());
        }
        // Não compila (descomente em aula para mostrar o erro):
        // Usuario generico = new Usuario(9, "Fulano", "f@email.com");   // error: Usuario is abstract

        // 4. POLIMORFISMO NAS REGRAS DE NEGÓCIO: frete sem perguntar o tipo do produto.
        System.out.println("== 4. Frete polimórfico ==");
        ProdutoFisico notebook = new ProdutoFisico(5, "Notebook", 3500.0, 4, informatica, 2.5);
        List<Produto> catalogo = new ArrayList<>();
        catalogo.add(mouse);
        catalogo.add(notebook);
        catalogo.add(cursoJava);
        for (Produto produto : catalogo) {
            System.out.println(produto.getNome() + " -> frete R$ " + String.format("%.2f", produto.calcularFrete()));
        }

        // 5. Item ABSTRATO: ItemCarrinho e ItemPedido calculam o subtotal cada um do seu jeito.
        System.out.println("== 5. Item abstrato ==");
        Carrinho carrinho = new Carrinho(ana);
        carrinho.adicionar(mouse, 2);
        carrinho.adicionar(notebook, 1);
        carrinho.adicionar(cursoJava, 1);
        for (Item item : carrinho.getItens()) {   // lista de Item: tanto faz a filha
            System.out.println(item.getDescricao() + " = R$ " + String.format("%.2f", item.getSubtotal()));
        }
        System.out.println("Frete do carrinho: R$ " + String.format("%.2f", carrinho.calcularFrete()));
        System.out.println("Total com frete: R$ " + String.format("%.2f", carrinho.calcularTotalComFrete()));

        // 6. INTERFACE: um contrato, várias formas de pagar.
        System.out.println("== 6. Interface Pagamento ==");
        Pedido pedido = carrinho.finalizarCompra();
        List<Pagamento> formas = new ArrayList<>();
        formas.add(new PagamentoPix("ana@email.com"));
        formas.add(new PagamentoCartao("4321", 5));
        formas.add(new PagamentoBoleto());
        for (Pagamento forma : formas) {
            System.out.println(forma.getNome() + ": R$ "
                    + String.format("%.2f", forma.calcularValorFinal(pedido.calcularTotalComFrete())));
        }

        pedido.pagar(new PagamentoCartao("4321", 9));    // recusado: o pedido continua FECHADO
        pedido.pagar(new PagamentoPix("ana@email.com")); // aprovado
        pedido.pagar(new PagamentoBoleto());             // já está pago
        System.out.println("Status do pedido: " + pedido.getStatus());
    }
}
