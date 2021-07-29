package br.com.caelum.contas.modelo;

/**
* Classe responsável por moldar	as Contas do Banco
*
* @Matheus Souza
*/

public abstract class Conta{//defini Conta classe abstrata 
    /* Quando criamos uma classe com todos os atributos privados, seus getters e setters e um construtor vazio(padrão), 
    na verdade estamos criando um java bean
     */
    protected double limite;
    protected double saldo;
    private int numero;
    private String agencia;
    private Data data_abertura;
    private Cliente titularObj;
    /* Quando declaramos um atributo como static, ele passa a ser um atributo da classe e não de cada objeto.
    Para acessarmos um atributo estático, não se usa o this, e sim o nome da classe: ex.: Conta.totalDecontas */
    private static int totalDeContas;
    private int id_conta; 
    //titular foi add, para surtir efeito na interface gráfica, servindo propósitos do capítulo 8
    private String titular;
   
   
    public Conta(int numero, String agencia, Data data_abertura, double limite){
        this.numero = numero;
        this.agencia = agencia;
        this.data_abertura = data_abertura;
        this.limite = limite;
        
        Conta.totalDeContas += 1;
        this.id_conta = Conta.totalDeContas;
    }
    public Conta(int numero, String agencia, Data data_abertura, double limite, Cliente cliente){
        this(numero, agencia, data_abertura, limite);
        this.titularObj = cliente;
        this.titular = titularObj.getNome();
        
        Conta.totalDeContas += 1;
        this.id_conta = Conta.totalDeContas;
    }
    public Conta(){
        Conta.totalDeContas += 1;
        this.id_conta = Conta.totalDeContas;
    }
    public Conta(String agencia, int numero, String titular){
        this.agencia = agencia;
        this.numero  = numero;
        this.titular = titular;
        
        Conta.totalDeContas += 1;
        this.id_conta = Conta.totalDeContas;
    }
    /* O conjunto de métodos públicos de uma classe é também chmado de interface da classe**, 
    pois está é a única maneira a qual você se comunica com objetos dessa classe. */
    public void sacar(double valor){
        if(!(this.saldo+this.limite>=valor && valor>0))
            throw new SaldoInsuficienteException(valor);
        else
            this.saldo = this.saldo - valor;
    }
    
    public void depositar(double valor){
        if(valor<=0)
            throw new IllegalArgumentException("\nArgumento inválido! valor não permitido.");    
        else
            this.saldo+=valor;
    }
   
    public abstract String getTipo();
    
    public void transferePara(double valor, Conta c){
        
        try{
            this.sacar(valor);
            c.depositar(valor);
        }catch(SaldoInsuficienteException e){
            System.out.println(e.getMessage()+", erro durante processo de transferencia!");
        }
    } 
    
    //getters não precisam apenas retornar atributos. Eles podem trabalhar com esses dados
    public double getRendimentoMensal(){
        return this.saldo*0.1;
    }
    /* Regras para a reescrita do método equals: 
        pelo contrato definido pela a classe object devemos retornar false também no caso do objeto passado não ser de tipo compatível com a sua classe.
        Então antes de fazer o casting devemos verificar isso, e para tal usamos a palavra chave instanceof, ou teríamos uma exception sendo lançada.
        Além disso, podemos resumir nosso equals de tal forma a não usar um if: */
    @Override
    public boolean equals(Object obj){
        if(obj == null)
            return false;
        if(!(obj instanceof Conta))
            return false;
        
        Conta c = (Conta) obj;
        return (this.numero == c.numero && this.agencia.equals(c.agencia));
    }
    
    @Override
    public String toString(){
        return "Titular: "+this.titular.toUpperCase()
                +"/ Número: "+this.numero
                +"/ Agencia: "+this.agencia;
    }
    
    public void recuperarDadosParaImpressao(){
        String dados;
        
        if(this.titularObj==null) {
             this.titular = "A conta ainda não possui um cliente associado\n\n";
             dados= "\nTitular: "+this.titular;
        }
        else
            dados= this.titularObj.getImpressao();
        
        
        dados +="\n------- Dados da conta --------\n"
        +"\nNúmero: "+this.numero
        +"\nAgencia: "+this.agencia;
        
        if(this.data_abertura!=null)
            dados+="\nData de abertura: "+this.data_abertura.formatada();
        else
            dados+="\nData de abertura: sem data registrada";
        
        dados+="\nSaldo: "+this.getSaldo()
        +"\nRendimento mensal: "+this.getRendimentoMensal();
            
        System.out.println(dados);
    }
    
    //getters - No caso de atributos booleanos, pode-se usar no lugar do get o sufixo is, ex.: isLigado
    public int getNumero() {
        return numero;
    }
    public String getAgencia() {
        return agencia;
    }
    public double getSaldo() {
        //retorna o saldo somado ao limite (prática comum de alguns bancos)
        return this.saldo+this.limite;
    }
    public Data getData_abertura() {
        return data_abertura;
    }
    public Cliente getTitularObj() {
        return titularObj;
    }
    /*A ideia é a mesma do atributo, static transforma o método como sendo de toda a classe e não de um objeto apenas. 
    ex.: main... int total = Conta.getTotalDeContas(); */
    public static int getTotalDeContas() {
        return totalDeContas;
    }
    public int getId_conta() {
        return id_conta;
    }

    public String getTitular() {
        return titular;
    }
    
     
    //setters - sem set saldo, uma vez que isso é feito nas próprias funções de saque e deposito
    public void setLimite(double limite) {
        this.limite = limite;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }
    
}

