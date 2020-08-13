package Model;

import Core.Eleitor;

/**
 * [SIMULADOR DE ATENDIMENTO EM ZONA ELEITORAL - PPOO Projeto Pratico]
 * 
 * Herdeira da classe Eleitor, a presente classe descreve o modelo
 * da entidade  especifica EleitorComum.
 * 
 * @author Lucas Fonseca dos Santos
 * @author Marco Aurelio Ferreira de Sousa
 * 
 */
public class EleitorComum extends Eleitor {

    /**
     * Construtor da classe.
     * 
     * @param nome              <code>String</code> nome do eleitor.
     * @param tituloEleitor     <code>integer</code> numero do titulo de eleitor.
     * @param tipoAtendimento  <code>String</code> tipo de atendimento solicitado pelo eleitor.
     */
    public EleitorComum(String nome, int tituloEleitor, String tipoAtendimento) {

        super(nome, tituloEleitor, 2, 0, tipoAtendimento);

    }

}