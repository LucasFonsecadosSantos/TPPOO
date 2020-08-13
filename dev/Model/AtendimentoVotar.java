package Model;

import Core.Atendimento;
import Core.Eleitor;

/**
 * [SIMULADOR DE ATENDIMENTO EM ZONA ELEITORAL - PPOO Projeto Pratico]
 * 
 * Herdeira da classe Atendimento, a presente classe descreve o modelo
 * da entidade  especifica AtendimentoVotar..
 * 
 * @author Lucas Fonseca dos Santos
 * @author Marco Aurelio Ferreira de Sousa
 * 
 */
public class AtendimentoVotar extends Atendimento {

    /**
     * Construtor da Classe.
     * 
     * @param eleitor Objeto do tipo <code>Eleitor</code> que sera atendido.
     */
    public AtendimentoVotar(Eleitor eleitor) {

        super(eleitor, 2);
        eleitor.setTipoAtendimento("votar");
        
    }

}