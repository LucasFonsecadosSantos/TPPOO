package Model;

import Core.Atendente;

/**
 * [SIMULADOR DE ATENDIMENTO EM ZONA ELEITORAL - PPOO Projeto Pratico]
 * 
 * Herdeira da classe Atendente, a presente classe descreve o modelo
 * da entidade  especifica AtendenteIniciante..
 * 
 * @author Lucas Fonseca dos Santos
 * @author Marco Aurelio Ferreira de Sousa
 * 
 */
public class AtendenteIniciante extends Atendente {

    /**
     * Construtor da classe.
     * 
     * @param nome <code>String</code> Nome do atendente.
     */
    public AtendenteIniciante(String nome) {

        super(nome, 2);

    }

}