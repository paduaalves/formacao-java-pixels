package br.com.padua;

import java.util.ArrayList;
import java.util.List;

/*
 * CARRINHO (versão da aula 07)
 *
 * É a etapa INTERMEDIÁRIA da compra: o cliente escolhe, muda de ideia,
 * aumenta, diminui, tira. Tudo aqui é mutável. Quando ele decide comprar,
 * finalizarCompra() transforma o carrinho em um Pedido fechado.
 *
 * RELACIONAMENTOS
 *
 *   Carrinho ---> Cliente          ASSOCIAÇÃO: o cliente existe antes e
 *                                  depois do carrinho. Só guardamos a referência.
 *
 *   Carrinho <>--> ItemCarrinho    COMPOSIÇÃO: os itens nascem aqui dentro
 *                                  (new ItemCarrinho em adicionar) e só
 *                                  existem por causa deste carrinho.
 *
 * O QUE MUDOU EM RELAÇÃO À AULA 05
 *
 * 1. A lista guarda ItemCarrinho (produto + quantidade), não Produto solto.
 *    Agora dá para comprar 2 mouses.
 * 2. O desconto fica no CARRINHO (percentualDesconto) e é aplicado sobre
 *    o total. O Produto não é alterado. Na aula 05, o desconto do carrinho
 *    mudava o preço do catálogo para todo mundo.
 */
public class Carrinho {

    private Cliente cliente;                 // associação
    private List<ItemCarrinho> itens;        // composição
    private Double percentualDesconto;

    public Carrinho(Cliente cliente) {
        this.cliente = cliente;
        this.itens = new ArrayList<>();      // sem isto, itens seria null
        this.percentualDesconto = 0.0;
    }

    public Cliente getCliente() {
        return cliente;
    }

    // Cópia da lista: de fora dá para ler, mas não para burlar adicionar.
    public List<ItemCarrinho> getItens() {
        return new ArrayList<>(itens);
    }

    public Double getPercentualDesconto() {
        return percentualDesconto;
    }

    // Procura o item de um produto. Devolve null se não encontrar.
    private ItemCarrinho buscarItem(Produto produto) {
        for (ItemCarrinho item : itens) {
            // == compara referências: é o MESMO objeto Produto?
            if (item.getProduto() == produto) {
                return item;
            }
        }
        return null;
    }

    /*
     * ADICIONAR: quem chama informa Produto e quantidade.
     * O ItemCarrinho é criado AQUI dentro. Isso é a composição no código.
     */
    public void adicionar(Produto produto, Integer quantidade) {
        if (produto == null || quantidade == null || quantidade <= 0) {
            System.out.println("Produto ou quantidade inválidos.");
            return;
        }
        ItemCarrinho existente = buscarItem(produto);
        if (existente != null) {
            if (!produto.temEstoque(existente.getQuantidade() + quantidade)) {
                System.out.println("Estoque insuficiente de " + produto.getNome() + ".");
                return;
            }
            existente.aumentarQuantidade(quantidade);
            System.out.println("+" + quantidade + " " + produto.getNome() + " (agora " + existente.getQuantidade() + ")");
            return;
        }
        if (!produto.temEstoque(quantidade)) {
            System.out.println("Estoque insuficiente de " + produto.getNome() + ".");
            return;
        }
        itens.add(new ItemCarrinho(produto, quantidade));
        System.out.println(quantidade + "x " + produto.getNome() + " entrou no carrinho de " + cliente.getNome() + ".");
    }

    public void remover(Produto produto) {
        ItemCarrinho item = buscarItem(produto);
        if (item == null) {
            System.out.println("Produto não está no carrinho.");
            return;
        }
        itens.remove(item);   // fora de qualquer for-each
        System.out.println(produto.getNome() + " saiu do carrinho.");
    }

    // Quantidade 0 significa "tirar do carrinho".
    public void alterarQuantidade(Produto produto, Integer novaQuantidade) {
        ItemCarrinho item = buscarItem(produto);
        if (item == null) {
            System.out.println("Produto não está no carrinho.");
            return;
        }
        if (novaQuantidade == null || novaQuantidade < 0) {
            System.out.println("Quantidade inválida.");
            return;
        }
        if (novaQuantidade == 0) {
            remover(produto);
            return;
        }
        if (!produto.temEstoque(novaQuantidade)) {
            System.out.println("Estoque insuficiente de " + produto.getNome() + ".");
            return;
        }
        item.definirQuantidade(novaQuantidade);
        System.out.println(produto.getNome() + " agora com " + novaQuantidade + " unidade(s).");
    }

    // Desconto do CARRINHO: não mexe no Produto.
    public void aplicarDesconto(Double percentual) {
        if (percentual == null || percentual < 0 || percentual > 100) {
            System.out.println("Desconto inválido.");
            return;
        }
        this.percentualDesconto = percentual;
        System.out.println("Desconto de " + percentual + "% aplicado ao carrinho.");
    }

    // Soma dos subtotais com o preço ATUAL de cada produto.
    public Double calcularSubtotal() {
        Double subtotal = 0.0;
        for (ItemCarrinho item : itens) {
            subtotal += item.getSubtotal();
        }
        return subtotal;
    }

    public Double calcularTotal() {
        return calcularSubtotal() * (1 - percentualDesconto / 100.0);
    }

    /*
     * FINALIZAR A COMPRA: a ponte entre Carrinho e Pedido.
     *
     * 1. Recusa carrinho vazio.
     * 2. Confere o estoque de novo (pode ter mudado desde que o item entrou).
     * 3. Cria o Pedido do mesmo cliente.
     * 4. Copia cada ItemCarrinho como ItemPedido. O ItemPedido tira a
     *    "foto" do preço deste momento.
     * 5. Leva o desconto e fecha o pedido (baixa estoque e trava).
     * 6. Esvazia o carrinho e devolve o Pedido para quem chamou.
     */
    public Pedido finalizarCompra() {
        if (itens.isEmpty()) {
            System.out.println("Carrinho vazio: nada para finalizar.");
            return null;
        }
        for (ItemCarrinho item : itens) {
            if (!item.getProduto().temEstoque(item.getQuantidade())) {
                System.out.println("Estoque insuficiente de " + item.getProduto().getNome() + ". Compra não finalizada.");
                return null;
            }
        }
        Pedido pedido = new Pedido(cliente);
        for (ItemCarrinho item : itens) {
            pedido.adicionarItem(item.getProduto(), item.getQuantidade());
        }
        pedido.aplicarDesconto(percentualDesconto);
        pedido.fechar();

        itens.clear();
        percentualDesconto = 0.0;
        System.out.println("Compra finalizada. O carrinho de " + cliente.getNome() + " está vazio de novo.");
        return pedido;
    }

    public void imprimirResumo() {
        System.out.println("----- Carrinho de " + cliente.getNome() + " -----");
        if (itens.isEmpty()) {
            System.out.println("(vazio)");
        }
        for (ItemCarrinho item : itens) {
            System.out.println(item.getQuantidade() + "x " + item.getProduto().getNome()
                    + " [" + item.getProduto().getCategoria().getNome() + "]"
                    + " R$ " + String.format("%.2f", item.getProduto().getPreco())
                    + " = R$ " + String.format("%.2f", item.getSubtotal()));
        }
        System.out.println("Subtotal: R$ " + String.format("%.2f", calcularSubtotal())
                + " | Desconto: " + percentualDesconto + "%"
                + " | Total: R$ " + String.format("%.2f", calcularTotal()));
    }
}
