package br.com.padua;

/*
 * AULA 08 - Herança e reutilização.
 * Usuario -> Cliente / Administrador e Produto -> ProdutoDigital.
 * Roteiro do live coding, na mesma ordem em que aparece no Main.
 * (O Main da aula 07 roda sem nenhuma mudança com estas classes.)
 */
public class Main {
    public static void main(String[] args) {

        // 1. Cliente É UM Usuario: o construtor é o mesmo da aula 07,
        //    e os métodos de Usuario vieram de graça (herança).
        Cliente ana = new Cliente(1, "Ana", "ana@email.com", "85999999999", "Rua A, 10", "12345678900");
        ana.definirSenha("123");               // regra herdada: mínimo de 6
        ana.definirSenha("ana12345");
        System.out.println("Login da Ana: " + ana.autenticar("ana@email.com", "ana12345"));
        System.out.println("Senha errada: " + ana.autenticar("ana@email.com", "000000"));
        ana.setEmail("ana.email.com");         // validação herdada de Usuario

        // 2. Administrador também É UM Usuario, com cargo e ações só dele.
        Administrador carlos = new Administrador(100, "Carlos", "carlos@loja.com", "Gerente de catálogo");
        carlos.definirSenha("admin2026");
        System.out.println("Login do Carlos: " + carlos.autenticar("carlos@loja.com", "admin2026"));
        carlos.setEmail("carlos @loja.com");   // a correção do e-mail vale para os dois

        // 3. O administrador cuida do catálogo.
        Categoria informatica = new Categoria(1, "Informática");
        Categoria livros = new Categoria(2, "Livros");
        Categoria cursos = new Categoria(3, "Cursos online");

        Produto mouse = new Produto(1, "Mouse sem fio", 80.0, 10, informatica);
        Produto livroJava = new Produto(3, "Livro Java para Iniciantes", 120.0, 3, livros);

        carlos.reajustarPreco(mouse, 90.0);
        carlos.reajustarPreco(mouse, -5.0);    // a validação continua no Produto
        carlos.reporEstoque(livroJava, 2);

        // 4. Sobrescrita (@Override): cada um exibe os dados do seu jeito.
        ana.exibirDados();
        carlos.exibirDados();

        // 5. ProdutoDigital É UM Produto: entra no carrinho e no pedido
        //    sem mudar uma linha de Carrinho ou Pedido.
        ProdutoDigital cursoJava = new ProdutoDigital(4, "Curso Java Online", 199.9, cursos, "https://loja.com/download/curso-java");
        Carrinho carrinho = new Carrinho(ana);
        carrinho.adicionar(mouse, 2);
        carrinho.adicionar(cursoJava, 1);
        carrinho.adicionar(livroJava, 10);     // físico: estoque insuficiente
        carrinho.imprimirResumo();
        System.out.println("Tem 1000 mouses? " + mouse.temEstoque(1000));
        System.out.println("Tem 1000 cursos? " + cursoJava.temEstoque(1000));

        Pedido pedido = carrinho.finalizarCompra();
        pedido.imprimirResumo();
        System.out.println("Estoque do mouse: " + mouse.getEstoque());
        System.out.println("Estoque do curso: " + cursoJava.getEstoque() + " (digital não usa estoque)");

        // Não compila (descomente em aula para mostrar o erro):
        // ana.reajustarPreco(mouse, 1.0);   // error: cannot find symbol (Cliente não é Administrador)
        // carlos.getCpf();                  // error: cannot find symbol (Administrador não tem CPF)
    }
}
