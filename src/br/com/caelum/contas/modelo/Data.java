package br.com.caelum.contas.modelo;

public class Data {
    private int dia;
    private int mes;
    private int ano;
    
    public Data(int dia, int mes, int ano){
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        
        if(!this.validarData()){
            this.dia = 0;
            this.mes = 0;
            this.ano = 0;
        }
    }
    
    public String formatada(){
        String dataFormatada;
        if(this.validarData())
            return dataFormatada = this.dia+"/"+this.mes+"/"+this.ano;
        else
            return "\n**** Data inválida! ****\n";
    }
    
    public boolean validarData(){
        if(this.mes>12) return false;
        switch(this.mes){
            case 4: 
            case 6:
            case 9:
            case 11: 
                if(this.dia>=1 && this.dia<=30) return true;
                else 
                    break;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12: 
                if(this.dia>=1 && this.dia<=31) return true;
                else 
                    break;
            case 2: 
                if((this.dia>=1 && this.dia<=28) || ((this.dia==29) && ( (ano%100==0 && ano%400==0) || ano%4==0 )))
                    return true;
                else
                    break;
                    
            default: break;             
        }
        return false;
    }
    
}
