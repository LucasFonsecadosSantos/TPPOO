package Model;

import Core.Atendimento;
import Core.Eleitor;

/**
 * [SIMULADOR DE ATENDIMENTO EM ZONA ELEITORAL - PPOO Projeto Pratico]
 * 
 * Herdeira da classe Atendimento, a presente classe descreve o modelo
 * da entidade  especifica AtendimentoJustificativa..
 * 
 * @author Lucas Fonseca dos Santos
 * @author Marco Aurelio Ferreira de Sousa
 * 
 */
public class AtendimentoJustificativa extends Atendimento {

    /**
     * Construtor da classe.
     * 
     * @param eleitor Objeto do tipo <code>Eleitor</code> utilizado no atenimdento.
     */
    public AtendimentoJustificativa(Eleitor eleitor) {
        
        super(eleitor, 1);
        eleitor.setTipoAtendimento("justificar");

    }

}