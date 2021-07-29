package br.com.caelum.contas;


import br.com.caelum.contas.modelo.Conta;
import br.com.caelum.contas.modelo.ContaCorrente;
import br.com.caelum.contas.modelo.ContaPoupanca;
import br.com.caelum.contas.modelo.SaldoInsuficienteException;
import br.com.caelum.javafx.api.util.Evento;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @Matheus Souza
 */
public class ManipuladorDeContas {
    private Conta conta;
    //private Data data;
    //private Cliente cliente;
    
    /* Para conseguirmos obter as informações da tela, todos os	métodos	que criaremos precisam receber um parâmetro do tipo Evento que conterá as informações 
    digitadas. Mesmo que não utilizemos	este parâmetro,	precisamos recebê-lo.*/
    public void	criaConta(Evento evento){
        String tipo = evento.getSelecionadoNoRadio("tipo");
        
        if(tipo.equals("Conta Corrente")){
            this.conta = new ContaCorrente();
        }else if(tipo.equals("Conta Poupança")){
            this.conta = new ContaPoupanca();
        }
        this.conta.setAgencia(evento.getString("agencia"));
        this.conta.setNumero(evento.getInt("numero"));
        this.conta.setTitular(evento.getString("titular"));
    }
    
    public void	deposita(Evento	evento){
        double valorDigitado = evento.getDouble("valorOperacao");
        try{
            this.conta.depositar(valorDigitado);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
    public void	saca(Evento evento){
        double valorDigitado = evento.getDouble("valorOperacao"); 
        
        try{
            this.conta.sacar(valorDigitado);
        }catch(RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
    public void transfere(Evento evento){
        Conta destino = (Conta) evento.getSelecionadoNoCombo("destino");
        
        try{
            this.conta.transferePara(evento.getDouble("valorTransferencia"), destino);
        }catch(RuntimeException e){
            System.out.println(e.getMessage());
        }
    }   
}