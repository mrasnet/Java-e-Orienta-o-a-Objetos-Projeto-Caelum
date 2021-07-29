package br.com.caelum.contas;

import br.com.caelum.contas.modelo.Autenticavel;

/**
 *
 * @Matheus Souza
 * 
 * O que um objeto faz é mais importante do que como ele faz. Aqueles que seguem essa regra, terão sistemas mais fáceis de manter e modificar
 */
public class SistemaInterno {
    /* Quando crio uma variável	do tipo Autenticavel, estou criando uma referência para qualquer objeto de uma classe que implemente Autenticavel, direta 
    ou indiretamente:*/
    
    //No dia em	que tivermos mais um funcionário com acesso ao sistema, basta que ele implemente essa interface (Autenticavel), para se encaixar no sistema.
    //Olhe só o	tamanho	do desacoplamento: quem	escreveu o SistemaInterno só precisa saber que ele é Autenticavel.	.
    public void login(Autenticavel a){
       int senha = 1234; 
       /* aqui eu posso chamar o autentica! não necessariamente	é um Funcionario! Mais ainda, eu não sei que objeto a referência "a" está apontando 
       exatamente! Flexibilidade. */
       boolean ok = a.autentica(senha);
    }
}
