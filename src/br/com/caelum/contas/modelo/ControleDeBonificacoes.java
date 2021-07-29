package br.com.caelum.contas.modelo;

import br.com.caelum.contas.modelo.Funcionario;

/**
 * É esse o poder do polimorfismo, juntamente com a reescrita de método: diminuir o acoplamento	entre as classes, para evitar que novos códigos	resultem 
 * em modificações em inúmeros lugares.
 * 
 * @Matheus Souza
 */
public class ControleDeBonificacoes {
    /* Repare que quem criou ControleDeBonificacoes pode nunca ter imaginado a criação da classe Secretaria ou Engenheiro. Contudo, não será necessário	
    reimplementar esse controle em cada nova classe: reaproveitamos aquele código. */
    private double totalDeBonicacoes = 0;
    
    public void registra(Funcionario funcionario){
        //Não importa como nos referenciamos a um objeto, o método que será invocado é sempre o	dele.
        System.out.println("Adicionando bonificação do funcionario(a): "+funcionario.getNome());
        this.totalDeBonicacoes += funcionario.getBonificacao();
    }
    public double getTotalDeBonificacoes(){
        return this.totalDeBonicacoes;
    }
}
