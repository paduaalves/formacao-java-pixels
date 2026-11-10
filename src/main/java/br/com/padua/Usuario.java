package br.com.padua;

/*
 * AULA 08 - HERANÇA: a classe MÃE (superclasse)
 *
 * Na aula 07 ficou a pergunta: a loja vai ter clientes E administradores.
 * Os dois têm id, nome, e-mail e senha. Copiar e colar esses atributos
 * nas duas classes? Não: o que é comum sobe para uma classe mãe.
 *
 *            Usuario            (o que TODO usuário tem e faz)
 *           /       \
 *      Cliente    Administrador (só o que é DIFERENTE de cada um)
 *
 * Teste do "é-um": um Cliente É UM Usuario; um Administrador É UM Usuario.
 * Se a frase soa estranha, não é herança (Pedido é um Carrinho? Não!).
 *
 * Os atributos continuam private (aula 06). As filhas HERDAM os métodos
 * public (getNome, setEmail, autenticar...), mas não enxergam os
 * atributos private da mãe: dentro de Administrador, usamos getNome().
 */
public class Usuario {

    private Integer id;
    private String nome;
    private String email;
    private String senha;

    // A senha não entra no construtor: ela é definida depois, com regra.
    public Usuario(Integer id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
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

    // Não existe getSenha de propósito: senha não sai do objeto.

    // Veio do Cliente da aula 07, agora recusando espaço também.
    // Corrigido AQUI, vale para TODOS os usuários (Cliente e Administrador).
    public void setEmail(String email) {
        if (email == null || !email.contains("@") || email.contains(" ")) {
            System.out.println("E-mail inválido: " + email);
            return;
        }
        this.email = email;
    }

    public void definirSenha(String senha) {
        if (senha == null || senha.length() < 6) {
            System.out.println("Senha recusada para " + nome + ": mínimo de 6 caracteres.");
            return;
        }
        this.senha = senha;
        System.out.println("Senha de " + nome + " definida.");
    }

    // Login: confere e-mail e senha. equals compara o CONTEÚDO dos textos.
    public Boolean autenticar(String email, String senha) {
        return this.senha != null && this.email.equals(email) && this.senha.equals(senha);
    }

    // As filhas vão SOBRESCREVER este método para mostrar os próprios dados.
    public void exibirDados() {
        System.out.println("Usuário #" + id + ": " + nome + " <" + email + ">");
    }
}
