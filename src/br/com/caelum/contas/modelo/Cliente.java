package br.com.caelum.contas.modelo;

import java.util.Arrays;
/**
* Classe responsável por moldar	os Clientes do Banco
*
* - por Matheus Souza
*/
public class Cliente {
    private String nome;
    private String endereco;//add recent.
    private String cpf;
    private int id_cliente;
    private static int contCliente;

    
    public Cliente(String nome, String endereco, String cpf){
        
        this.nome = nome;
        this.endereco = endereco;
        this.cpf = cpf; 
       
        if(!validaCpf())
            this.cpf = "000.000.000-00";
       
        contCliente += 1;
        this.id_cliente = contCliente;
    }    
    
    public boolean validaCpf(){
        char[] aux = new char[this.cpf.length()];
        
        if(this.cpf.length()!=14){
            System.out.println("Fomato não suportado para cpf, tamanho inválido...");
            return false;
        }
        aux = this.cpf.toCharArray();    
        if(
           aux[3]=='.' && aux[7]=='.' && aux[11]=='-' 
           && aux[0]!='0' && aux[4]!='0' && aux[8]!='0' && aux[12]!='0'
           ){
            for(char ch : aux){
                if(!((ch=='.' || ch=='-') || (ch>=49 && ch<=57 || ch=='0'))) {
                     return false;
                /*
                if(ch=='.' || ch=='-') { 
                }else
                    if(ch>=49 && ch<=57 || ch=='0') {          
                    } else
                        return false;
                */
                }
            }
        }else
            return false;
        
    return true;
}
    
    public String getImpressao(){
        String dados = "\n------ Dados Cliente -------\n"+
                "\nNome: "+this.nome+
                "\nEndereço: "+this.endereco;
                if(!this.validaCpf())
                    dados+="\nCPF: "+"formato não permitido";
                else 
                    dados+="\nCPF: "+this.cpf;
            dados+="\nIdentificador: "+this.id_cliente+"\n";
        
        return dados;
    }
    
    public String getNome() {
        return nome;
    }
    public String getEndereco() {
        return endereco;
    }
    public String getCpf() {
        return cpf;
    }
    public int getId_cliente() {
        return id_cliente;
    }
    public static int getContCliente() {
        return contCliente;
    }
}
