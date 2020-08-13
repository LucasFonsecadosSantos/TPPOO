package Model;

import Core.Atendente;

/**
 * [SIMULADOR DE ATENDIMENTO EM ZONA ELEITORAL - PPOO Projeto Pratico]
 * 
 * Herdeira da classe Atendente, a presente classe descreve o modelo
 * da entidade  especifica AtendenteExperiente..
 * 
 * @author Lucas Fonseca dos Santos
 * @author Marco Aurelio Ferreira de Sousa
 * 
 */
public class AtendenteExperiente extends Atendente {

    /**
     * Construtor da classe.
     * 
     * @param nome <code>String</code> nome do atendente.
     */
    public AtendenteExperiente(String nome) {

        super(nome, 1);

    }

}