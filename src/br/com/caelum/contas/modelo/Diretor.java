package br.com.caelum.contas.modelo;

/**
 *
 * @Matheus Souza
 */
public class Diretor extends Funcionario implements Autenticavel {

    @Override
    public double getBonificacao() {
        return 2.0;
    }

    @Override
    public boolean autentica(int senha) {
        return true;
    }
    
}
