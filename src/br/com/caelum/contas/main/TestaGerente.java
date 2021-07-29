package br.com.caelum.contas.main;

import br.com.caelum.contas.modelo.ControleDeBonificacoes;
import br.com.caelum.contas.modelo.Funcionario;
import br.com.caelum.contas.modelo.Gerente;

/**
 * É esse o poder do polimorfismo, juntamente com a reescrita de método: diminuir o acoplamento	entre as classes, para evitar que novos códigos	resultem 
 * em modificações em inúmeros lugares.
 * 
 * @Matheus Souza
 */
public class TestaGerente {
    public static void main(String[] args) {
        Gerente g = new Gerente();
        
        g.setNome("Matheus");
        g.setSenha(1234);
        g.setSalario(5000);
        System.out.println("Nome gerente: "+g.getNome());
        System.out.println("Password: "+g.getSenha());
        System.out.println("salario: "+g.getSalario());
        System.out.println("bonificação anual: "+g.getBonificacao());
        /* Polimorfismo - controle recebe um obj tipo func. gerente é um tipo de func, e dentro do método registra* estamos chamando na verdade o 
        getBonif. daquele objeto, que por motivos de sobrescrita chama o método específico daquele objeto.
         */
        Funcionario f = g;
        ControleDeBonificacoes controle = new ControleDeBonificacoes(); 
        controle.registra(f);
        
        //Funcionario f2 = new Funcionario(); //Para funcionar remover o modificador abstract em Funcionario
        //f2.setSalario(5000);
        //f2.setNome("Carla");
        //ControleDeBonificacoes controle2 = new ControleDeBonificacoes(); 
        //controle2.registra(f2);
        
        //Aqui ao buscar o total de bonificações vemos que o valor foi aplicado pelo o método sobrescrito de Funcionario em Gerente.
        System.out.println("Total de bonificações: "+controle.getTotalDeBonificacoes());
        //System.out.println("Total de bonificações 2: "+controle2.getTotalDeBonificacoes());
        
    }
}
