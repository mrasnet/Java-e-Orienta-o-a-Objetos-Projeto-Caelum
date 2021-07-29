package br.com.caelum.contas.modelo;

/**
 *
 * @author Mras
 */
public class SaldoInsuficienteException extends RuntimeException{
    SaldoInsuficienteException(double valor){
        super("Operação inválida! Não é permitido sacar "+valor);
    }
}
