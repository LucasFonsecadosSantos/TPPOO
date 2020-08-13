package Core;

/**
 * [SIMULADOR DE ATENDIMENTO EM ZONA ELEITORAL - PPOO Projeto Pratico]
 * 
 * A presente classe representa a entidade eleitor e o modelo
 * de suas informacoes. Essa entidade e utilizada no sistema
 * para representar um eleitor a ser processado na simuacao.
 * 
 * Essa e uma superclasse que possui como hedeiros a entidade EleitorComum
 * e EleitorPreferencial.
 * 
 * @author Lucas Fonseca dos Santos
 * @author Marco Aurelio Ferreira de Sousa
 * 
 */
public abstract class Eleitor {

    private String nome;
    private int tituloEleitor;
    private int tempo;
    private int prioridade;
    private String tipoAtendimento;

    /**
     * Construtor da entidade.
     * 
     * @param nome              <code>String</code> nome do eleitor.
     * @param tituloEleitor     <code>integer</code> numero do titulo de eleitor.
     * @param tempo             <code>integer</code> tempo que o presente eleitor ocupa na simuacao.
     * @param prioridade        <code>integer</code> criterio de prioridedade de atenidmento.
     * @param tipoAtendimento   <code>String</code> tipo de atendimento Votar ou Justificar.
     */
    public Eleitor(String nome, int tituloEleitor, int tempo, int prioridade, String tipoAtendimento) {

        this.nome = nome;
        this.tituloEleitor = tituloEleitor;
        this.tempo = tempo;
        this.prioridade = prioridade;
        this.tipoAtendimento = tipoAtendimento;

    }

    /**
     * Metodo acessador do estado do atributo nome.
     * 
     * @return <code>String</code> nome do eleitor, estado do atributo nome.
     */
    public String getNome() {

        return this.nome;

    }

    /**
     * Metodo acessador do estado do atributo titulo de eleitor.
     * 
     * @return <code>integer</code> numero do titulo de eleitor.
     */
    public int getTituloEleitor() {

        return tituloEleitor;

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
     * Metodo acessador do estado do atributo prioridade.
     * 
     * @return <code>integer</code> estado do atributo prioridade.
     */
    public int getPrioridade() {

        return prioridade;

    }

    /**
     * Metodo acessador do estado do atributo tipoAtendimento.
     * 
     * @return <code>String</code> estado do atributo tipoAtendimento.
     */
    public String getTipoAtendimento() {

        return tipoAtendimento;

    }

    /**
     * Metodo modificador do atributo tipoAtendimento.
     * Este atributo descreve qual o tipo de evento o presente eleitor
     * solicita ao sistema de simulacao para que seja processador,
     * votar ou justificar.
     * 
     * @param tipoAtendimento Valor do tipo <code>String</code> referente ao tipo de
     *                          Atendimento, justificar ou votar.
     */
    public void setTipoAtendimento(String tipoAtendimento) {

        this.tipoAtendimento = tipoAtendimento;
        
    }

    /**
     * Metodo sobrescrito de Object.
     * Descreve de forma textual o estado do objeto.
     * 
     * @return <code>String</code> estado do objeto.
     */
    @Override
    public String toString() {
        return "Eleitor [nome=" + nome + ", prioridade=" + prioridade + ", tempo=" + tempo + ", tipoAtendimento="
                + tipoAtendimento + ", tituloEleitor=" + tituloEleitor + "]";
    }

    

    

}