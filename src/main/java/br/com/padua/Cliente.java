package br.com.padua;

/*
 * CLIENTE (versão da aula 08)
 *
 * Na aula 07, Cliente tinha id, nome, email, telefone, endereco e cpf,
 * além do setEmail com validação. Agora ele HERDA de Usuario:
 *
 *     public class Cliente extends Usuario
 *
 * extends = "é um". Tudo o que é comum (id, nome, email, senha,
 * setEmail, definirSenha, autenticar) mora em Usuario. Aqui fica só o
 * que é ESPECÍFICO de cliente: telefone, endereço e CPF.
 *
 * O construtor público continua igual ao da aula 07 (6 parâmetros):
 * o Main e o Carrinho/Pedido não precisaram mudar nada.
 */
public class Cliente extends Usuario {

    private String telefone;
    private String endereco;
    private String cpf;

    public Cliente(Integer id, String nome, String email, String telefone, String endereco, String cpf) {
        super(id, nome, email);   // 1ª linha: monta a "parte Usuario" do objeto
        this.telefone = telefone;
        this.endereco = endereco;
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /*
     * SOBRESCRITA: mesmo nome, mesmos parâmetros do método da mãe.
     * super.exibirDados() reaproveita a linha que Usuario já sabe imprimir;
     * depois completamos com o que só o cliente tem.
     */
    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("  Cliente | CPF " + cpf + " | tel. " + telefone + " | " + endereco);
    }
}
