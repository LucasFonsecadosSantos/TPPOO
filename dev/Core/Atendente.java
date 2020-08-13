package Core;

/**
 * [SIMULADOR DE ATENDIMENTO EM ZONA ELEITORAL - PPOO Projeto Pratico]
 * 
 * A presente classe representa a entidade atendente e o modelo
 * de suas informacoes. Essa entidade e utilizada no sistema
 * para realizar os atendimentos a cada unidade atendida (eleitor).
 * 
 * Essa e uma superclasse que possui como hedeiros a entidade AtendenteExperiente
 * e AtendenteIniciante.
 * 
 * @author Lucas Fonseca dos Santos
 * @author Marco Aurelio Ferreira de Sousa
 * 
 */
public abstract class Atendente {
    
    private String nome;
    private int tempo;
    private int tempoEstado;

    /**
     * Construtor da superclasse atendente.
     * 
     * @param nome      nome do atendente.
     * @param tempo     unidade de tempo que o atendente em questao leva
     *                  para realizar um atendimento.
     */
    public Atendente(String nome, int tempo) {

        this.setNome(nome);
        this.setTempo(tempo);

    }

    /**
     * Metodo para verificar se o atendente esta livre para realizar um
     * atendimento.
     * 
     * @return  <code>true</code> Se o atendente estiver livre realizar
     *          um atendimento. Retorna <code>false</code> se o atendente
     *          estiver realizando um atendimento naquele determinado ciclo
     *          de simulacao.
     */
    public boolean livre() {

        return (this.tempoEstado == 0);

    }

    /**
     * Metodo modificador responsavel pelo estado do ciclo de simulacao
     * do atendente em especifico. Um atendimento que comeca a ser
     * realizado, possui um tempo estado e a cada ciclo da simulacao,
     * este tempo estado e decrementado ate chegar a zero.
     * 
     * @param tempoAtendimento Tempo estado calculado.
     */
    public void setTempoEstado(int tempoAtendimento) {

        this.tempoEstado = (tempoAtendimento * this.tempo);

    }

    /**
     * Metodo acessador do atributo tempo estado.
     * 
     * @return <code>integer</code> Estado do atributo tempo estado.
     */
    public int getTempoEstado() {

        return this.tempoEstado;

    }

    /**
     * Metodo responsavel pela atualizacao do estado do atributo tempo estado.
     * A cada ciclo de simulacao, se o atendente estiver em um processo de atendimento,
     * o valor do tempo estado e decrementado. Ao se tornar zero, entao significa que
     * o atendimento que este atendente estava realizando, terminou.
     * 
     */
    public void atualizaTempoEstado() {

        this.tempoEstado--;

    }

    /**
     * Metodo acessador do estado do atributo nome.
     * 
     * @return <code>String</code> Estado do atributo nome.
     */
    public String getNome() {

        return nome;
        
    }

    /**
     * Metodo modificador do atributo nome.
     * 
     * @param nome Novo estado para o atributo nome. 
     */
    private void setNome(String nome) {

        this.nome = nome;

    }

    /**
     * Metodo acessador do estado do atributo tempo.
     * 
     * @return <code>integer</code> estado do atributo tempo.
     */
    public int getTempo() {

        return tempo;

    }


    /**
     * Metodo modificador do atributo tempo.
     * 
     * @param tempo Novo estado do atributo tempo.
     */
    private void setTempo(int tempo) {

        this.tempo = tempo;

    }

    /**
     * Metodo sobrescrito de Object.
     * 
     * @return <code>String</code> descricao textual do estado do objeto.
     */
    @Override
    public String toString() {
        
        return "Atendente [nome=" + nome + ", tempo=" + tempo + "]";
        
    }

    
    
}