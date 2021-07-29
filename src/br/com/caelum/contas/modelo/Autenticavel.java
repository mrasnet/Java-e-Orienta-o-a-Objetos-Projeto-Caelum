package br.com.caelum.contas.modelo;

/**
 *
 * @Matheus Souza
 * 
 * Chama-se interface pois é a maneira pela qual poderemos conversar com um Autenticavel. Interface é a	maneira	através	da qual	conversamos com	um objeto.
 * 
 * Lemos a interface da	seguinte maneira: "quem	desejar	ser autenticável precisa saber autenticar dado um inteiro e retornando um booleano". Ela é um contrato
 * onde	quem assina se responsabiliza por implementar esses métodos (cumprir o contrato).
 */
public interface Autenticavel {
    
    /* Uma interface pode definir uma série de métodos,	mas nunca conter implementação deles. Ela só expõe o que o objeto deve fazer, e	não como ele faz, nem
    o que ele tem. Como ele faz vai ser definido em uma implementação dessa interface.*/
    //métodos de uma interface são públicos e abstratos, sempre
    boolean autentica(int senha);
    
    /* Diferentemente das classes, uma interface pode herdar de	mais de	uma interface. É como um contrato que depende que outros contratos sejam fechados 
    antes deste valer. Você não herda métodos e atributos, mas sim responsabilidades.*/
    
    /* Um outro recurso em interfaces são os métodos default a partir do Java 8. Você pode sim declarar	um método concreto, utilizando a palavra default 
    ao lado, e suas implementações não precisam necessariamente reescrevê-lo. É um truque muito utilizado para poder evoluir uma interface sem quebrar 
    compatibilidade com as implementações anteriores.*/ 
}
