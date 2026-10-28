package br.com.padua;

/*
 * CLIENTE (versão da aula 07)
 *
 * Mesmos dados da aula 05, agora encapsulados (aula 06).
 * Na aula 07, Cliente é a outra ponta de uma ASSOCIAÇÃO:
 * um Pedido conhece o Cliente que comprou.
 */
public class Cliente {

    private Integer id;
    private String nome;
    private String email;
    private String telefone;
    private String endereco;
    private String cpf;

    public Cliente(Integer id, String nome, String email, String telefone, String endereco, String cpf) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cpf = cpf;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
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

    public void setEmail(String email) {
        if (email == null || !email.contains("@")) {
            System.out.println("E-mail inválido: " + email);
            return;
        }
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
