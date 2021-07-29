package br.com.caelum.contas.modelo;

/**
 *
 * @Math Souza
 */
public class ContaCorrente extends Conta implements Tributavel{
    @Override
    public String getTipo(){
        return "Conta Corrente";
    }
    
    @Override
    public void sacar(double valor){
        if(!(this.saldo+this.limite>=valor && valor>0)){
            throw new SaldoInsuficienteException(valor);
        }  
        else
            this.saldo -= (valor+0.10);
    }
    /* Alguns bens são tributáveis e outros não, ContaPoupanca não é tributável, já para ContaCorrente você precisa pagar 1% da	conta e	o SeguroDeVida
    tem	uma taxa fixa de 42 reais mais 2% do valor do seguro. */
    @Override
    public double getValorImposto() {
        return this.getSaldo()*0.01;
    }
}
