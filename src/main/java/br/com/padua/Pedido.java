package br.com.padua;

import java.util.ArrayList;
import java.util.List;

/*
 * PEDIDO: o registro da compra fechada.
 *
 * Nasce dentro de Carrinho.finalizarCompra(), recebe os itens, é fechado
 * e a partir daí não muda mais. É a "nota fiscal" da loja.
 *
 * RELACIONAMENTOS
 *
 *   Pedido ---> Cliente         ASSOCIAÇÃO: o cliente existe antes e
 *                               depois do pedido.
 *
 *   Pedido <>--> ItemPedido     COMPOSIÇÃO: os itens nascem aqui dentro
 *                               e só existem por causa deste pedido.
 *
 * IMUTÁVEL DEPOIS DE FECHADO
 *
 * Mexer em um pedido fechado não é um detalhe: é um erro de programação.
 * Por isso adicionarItem e aplicarDesconto LANÇAM UMA EXCEÇÃO em vez de
 * só imprimir uma mensagem. throw interrompe o método na hora, e quem
 * chamou é obrigado a perceber. (Tratamento de exceções em detalhe:
 * aula 27.)
 */
public class Pedido {

    private Cliente cliente;                  // associação
    private List<ItemPedido> itens;           // composição
    private Double percentualDesconto;
    private Boolean fechado;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.itens = new ArrayList<>();
        this.percentualDesconto = 0.0;
        this.fechado = false;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Boolean isFechado() {
        return fechado;
    }

    public String getStatus() {
        if (fechado) {
            return "FECHADO";
        }
        return "ABERTO";
    }

    public Double getPercentualDesconto() {
        return percentualDesconto;
    }

    public List<ItemPedido> getItens() {
        return new ArrayList<>(itens);
    }

    // O ItemPedido é criado aqui dentro: composição.
    public void adicionarItem(Produto produto, Integer quantidade) {
        if (fechado) {
            throw new IllegalStateException("Pedido fechado não pode receber itens.");
        }
        itens.add(new ItemPedido(produto, quantidade));
    }

    public void aplicarDesconto(Double percentual) {
        if (fechado) {
            throw new IllegalStateException("Pedido fechado não pode receber desconto.");
        }
        this.percentualDesconto = percentual;
    }

    public Double calcularSubtotal() {
        Double subtotal = 0.0;
        for (ItemPedido item : itens) {
            subtotal += item.getSubtotal();
        }
        return subtotal;
    }

    public Double calcularTotal() {
        return calcularSubtotal() * (1 - percentualDesconto / 100.0);
    }

    // Fechar: baixa o estoque de cada produto e trava o pedido.
    public void fechar() {
        if (fechado) {
            throw new IllegalStateException("Pedido já está fechado.");
        }
        if (itens.isEmpty()) {
            throw new IllegalStateException("Pedido sem itens não pode ser fechado.");
        }
        for (ItemPedido item : itens) {
            // O Pedido PEDE ao Produto. A regra de estoque mora no Produto.
            item.getProduto().baixarEstoque(item.getQuantidade());
        }
        this.fechado = true;
        System.out.println("Pedido de " + cliente.getNome() + " fechado. Total: R$ " + String.format("%.2f", calcularTotal()));
    }

    public void imprimirResumo() {
        System.out.println("===== Pedido de " + cliente.getNome() + " (" + getStatus() + ") =====");
        for (ItemPedido item : itens) {
            System.out.println(item.getQuantidade() + "x " + item.getProduto().getNome()
                    + " [" + item.getProduto().getCategoria().getNome() + "]"
                    + " R$ " + String.format("%.2f", item.getPrecoUnitario())
                    + " = R$ " + String.format("%.2f", item.getSubtotal()));
        }
        System.out.println("Subtotal: R$ " + String.format("%.2f", calcularSubtotal())
                + " | Desconto: " + percentualDesconto + "%"
                + " | Total: R$ " + String.format("%.2f", calcularTotal()));
    }
}
