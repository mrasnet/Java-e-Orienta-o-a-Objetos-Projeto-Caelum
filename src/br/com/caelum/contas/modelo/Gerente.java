package br.com.caelum.contas.modelo;

/**
 *
 * @Matheus Ronielli
 * 
 * O implements	pode ser lido da seguinte maneira: "A classe Gerente se	compromete a ser tratada como Autenticavel, sendo obrigada a ter os métodos 
 * necessários,	definidos neste	contrato".
 * 
 * A partir de agora, podemos tratar um	Gerente	como sendo um Autenticavel. Ganhamos mais polimorfismo!	Temos mais uma forma de referenciar a um Gerente
 */
public class Gerente extends Funcionario implements Autenticavel {    
    private int senha;
    private int numeroDeFuncionariosGerenciados;
    
    @Override
    public boolean autentica(int senha){
        if(this.senha == senha){
            System.out.println("Acesso Permitido!");
            return true;
        }else{
            System.out.println("Acesso Negado!");
            return false;
        }
        //pode fazer outras possíveis verificações, como saber se esse departamento do gerente tem acesso ao Sistema
    }
    
    @Override
    public double getBonificacao(){
        /* Caso queiramos a regra definida no getBoni... de Funcicionario, e essa mesma regra possa vir a ser alterada futaramente, e não queremos ter que
        definir a mudança manualmente em Gerente depois */
        return this.salario * 1.4 + 1000;//super permite acessar o método (aqui sobrescrito) na forma como ele é na superclasse
        /* Essa	é uma prática comum, pois muitos casos o método	reescrito geralmente faz "algo a mais" que o método da classe mãe. Chamar ou não o método
        de cima	é uma decisão sua e depende do seu problema. Algumas vezes não faz sentido invocar o método que	reescrevemos.*/
    }
    
    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public int getNumeroDeFuncionariosGerenciados() {
        return numeroDeFuncionariosGerenciados;
    }

    public void setNumeroDeFuncionariosGerenciados(int numeroDeFuncionariosGerenciados) {
        this.numeroDeFuncionariosGerenciados = numeroDeFuncionariosGerenciados;
    }
}
