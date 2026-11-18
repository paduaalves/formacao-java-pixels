package br.com.padua;

/*
 * ADMINISTRADOR (novo na aula 08)
 *
 * Também É UM Usuario: herda id, nome, email, senha, setEmail,
 * definirSenha e autenticar sem copiar uma linha sequer.
 *
 * O que é só dele: o cargo e as ações de quem cuida da loja
 * (reajustar preço, repor estoque). Cliente não tem esses métodos.
 *
 * Repare: aqui dentro escrevemos getNome(), e não nome.
 * O atributo nome é private em Usuario. Ele EXISTE no objeto, mas só
 * a própria classe Usuario mexe nele direto.
 */
public class Administrador extends Usuario {

    private String cargo;

    public Administrador(Integer id, String nome, String email, String cargo) {
        super(id, nome, email);
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    // A validação do preço continua morando no Produto (setPreco).
    public void reajustarPreco(Produto produto, Double novoPreco) {
        Double precoAnterior = produto.getPreco();
        produto.setPreco(novoPreco);
        System.out.println(getNome() + " reajustou " + produto.getNome()
                + ": R$ " + String.format("%.2f", precoAnterior)
                + " -> R$ " + String.format("%.2f", produto.getPreco()));
    }

    public void reporEstoque(Produto produto, Integer quantidade) {
        produto.reporEstoque(quantidade);
        System.out.println(getNome() + " repôs " + produto.getNome() + ". Estoque: " + produto.getEstoque());
    }

    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("  Administrador | cargo: " + cargo);
    }
}
