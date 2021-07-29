package br.com.caelum.contas;

import br.com.caelum.contas.modelo.SeguroDeVida;
import br.com.caelum.javafx.api.util.Evento;

/**
 *
 * @Matheus Souza
 */
public class ManipuladorDeSeguroDeVida {
    SeguroDeVida seguroVida;
    
    public void criaSeguro(Evento evento){
        this.seguroVida = new SeguroDeVida();
        this.seguroVida.setNumeroApolice(evento.getInt("numeroApolice"));
        this.seguroVida.setTitular(evento.getString("titular"));
        this.seguroVida.setValor(evento.getDouble("valor"));
    }
}
