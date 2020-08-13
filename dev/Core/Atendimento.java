package Core;

import java.lang.Comparable;

/**
 * [SIMULADOR DE ATENDIMENTO EM ZONA ELEITORAL - PPOO Projeto Pratico]
 * 
 * A presente classe representa a entidade atendimento e o modelo
 * de suas informacoes. Essa entidade e utilizada no sistema
 * para representar um evento de atendimento a ser processado.
 * 
 * Essa e uma superclasse que possui como hedeiros a entidade AtendimentoVotar
 * e AtenidmentoJustificar.
 * 
 * @author Lucas Fonseca dos Santos
 * @author Marco Aurelio Ferreira de Sousa
 * 
 */
public abstract class Atendimento implements Comparable<Eleitor> {

    private Eleitor eleitor;
    private int tempo;
    private int tempoAtendimento;
    private int tempoEspera;

    /**
     * Construtor da classe.
     * 
     * @param eleitor   Objeto do tipo <code>Eleitor</code> cujo devera ser atendido.
     * @param tempo     Valor do tipo <code>integer</code> que representa o tempo do presente evento.
     */
    public Atendimento(Eleitor eleitor, int tempo) {

        this.eleitor = eleitor;
        this.tempo = tempo;

    }

    /**
     * Metodo acessador do estado do atributo eleitor.
     * 
     * @return <code>Eleitor</code> Objeto do tipo Eleitor, o eleitor
     *          do presente atendimento.
     */
    public Eleitor getEleitor() {

        return eleitor;

    }

    /**
     * Metodo modificador do atributo tempoEspera.
     * Este atributo e utilizado para calcular algumas estatisticas
     * da simulacao. E o tempo de espera na fila.
     * 
     * @param tempo Valor do tipo <code>integer</code> que representa o tempo
     *              de espera na fila.
     */
    public void setTempoEspera(int tempo) {

        this.tempoEspera = tempo;

    }

    /**
     * Metodo modificador do atributo tempoAtendimento.
     * Este atributo e utilizado para calcular algumas estatisticas
     * da simulacao. E o tempo total do atendimento.
     * 
     * @param tempo Valor <code>integer</code> que representa o tempo
     *              total da ocorrencia do atendimento.
     */
    public void setTempoAtendimento(int tempo) {

        this.tempoAtendimento = tempo;

    }

    /**
     * Metodo responsavel pela atualizacao do tempo de espera
     * na fila de atendimento.
     * Este metodo incrementa o estado do atributo tempoEspera.
     */
    public void atualizaTempoEspera() {

        this.tempoEspera++;

    }

    /**
     * Metodo acessador do estado do atributo tempo.
     * 
     * @return <code>integer</code> Estado do atributo tempo.
     */
    public int getTempo() {

        return Math.max(this.tempo, this.eleitor.getTempo());

    }

    /**
     * Metodo acessador do estado do atributo tempoAtendimento.
     * 
     * @return <code>integer</code> Estado do atributo tempoAtendimento.
     */
    public int getTempoAtendimento() {

        return this.tempoAtendimento;

    }

    /**
     * Metodo acessador do estado do atributo tempoEspera.
     * 
     * @return <code>integer</code> estado do atributo tempoEspera.
     */
    public int getTempoEspera() {

        return tempoEspera;

    }

    /**
     * Metodo sobrescrito de Object.
     * Representa de forma textual o estado do objeto.
     * 
     * @return <code>String</code> o estado do objeto em questao.
     */
    @Override
    public String toString() {

        return "Atendimento [eleitor=" + eleitor + ", tempoAtendimento=" + tempoAtendimento + ", tempoEspera="
                + tempoEspera + "]";

    }

    /**
     * Metodo implementado da interface comparable.
     * Responsavel pela definicao de criterio de comparacao e prioriedade
     * na fila de prioridades de atendimento da simualacao.
     * 
     * @return <code>integer</code> criterio de comparacao.
     */
    @Override
    public int compareTo(Eleitor eleitor) {

        if (this.eleitor.getPrioridade() > eleitor.getPrioridade()) {

            return 1;

        } else if (this.eleitor.getPrioridade() < eleitor.getPrioridade()) {

            return -1;

        } else {

            return 0;

        }

    }

    
    

}