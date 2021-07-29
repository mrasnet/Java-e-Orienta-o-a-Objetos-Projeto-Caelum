package br.com.caelum.contas.modelo;

/**
 *	
 * @Matheus Ronielli
 */
/* Usamos a palavra chave abstract para impedir que a classe possa ser instanciada. Esse é o efeito direto de se usar o modificador abstract na declaração 
de uma classe. Serve para o polimorfismo e herança dos atributos e métodos, que	são recursos muito poderosos. */
public abstract class Funcionario {
    /* modificador de acesso protected fica entre o private e o	public. Um atributo protected só pode ser acessado (visível) pela própria classe, por suas 
    subclasses, e pelas classes	que se encontram no mesmo pacote. */
    protected String nome;
    protected String cpf;
    protected double salario;

    public Funcionario() {
    }
    //método abstrato deverá ser escrito pelas classes concretas filhas
    public abstract double getBonificacao();
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
       
}
