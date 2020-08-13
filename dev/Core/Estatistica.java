package Core;

import java.util.List;
import java.util.Collections;

/**
 * [SIMULADOR DE ATENDIMENTO EM ZONA ELEITORAL - PPOO Projeto Pratico]
 * 
 * A presente classe representa a estatistica da simulacao, calculada
 * apos sua execucao. Todas as metricas aqui capturadas e calculadas,
 * sao requisitos do projeto.
 * 
 * CLASSE ORIENTADA PELO PADRAO BUILDER.
 * 
 * @author Lucas Fonseca dos Santos
 * @author Marco Aurelio Ferreira de Sousa
 * 
 */
public class Estatistica {

    private int                 tempoTotal;
    private int                 quantidadeEventos;
    private double              tempoMedioFila;
    private double              tamanhoMedioFila;
    private int                 tamanhoMaximoFila;
    private double              tempoMedioTipoEleitor;
    private List<Atendimento>   atendimentosConcluidos;

    /**
     * Construtor da classe.
     * Construtor padrao, sua declaracao nao e necessaria,
     * declarado apenas para fins de organizacao.
     */
    public Estatistica() {}

    /**
     * Metodo modificador do atributo tempoTotal.
     * Este atributor representa o tempo total em que decorreu
     * a simulacao.
     * 
     * @param tempoTotal valor <code>integer</code> estado do atributo tempoTotal.
     * @return <code>Estatistica</code> Instancia do presente objeto para definicoes
     *          padrao builder.
     */
    public Estatistica setTempoTotal(int tempoTotal) {

        this.tempoTotal = tempoTotal;
        return this;

    }

    /**
     * Metodo modificador do estado do atributo quantidadeEventos.
     * Este atributo represente a quantidade total de eventos atendidos no
     * processamento da simuacao.
     * 
     * @param quantidadeEventos         Estado do atributo quantidadeEventos <code>integer</code>.
     * @return <code>Estatistica</code> Instancia do presente objeto para definicoes
     *          padrao builder.
     */
    public Estatistica setQuantidadeEventos(int quantidadeEventos) {

        this.quantidadeEventos = quantidadeEventos;
        return this;

    }

    /**
     * Metodo modificador do estado do atributo atendimentosConcluidos.
     * Este atributo armazena a lista com os atendimentos (eventos) concluidos
     * e processados pela simuacao.
     * 
     * @param atendimentosConcluidos    Estado do atributo atendimentosConcluidos <code>List Atendimento </code>
     * @return <code>Estatistica</code> Instancia do presente objeto para definicoes
     *          padrao builder.
     */
    public Estatistica setAtendimentosConcluidos(List<Atendimento> atendimentosConcluidos) {

        this.atendimentosConcluidos = atendimentosConcluidos;
        this.setTempoMedioFila();
        return this;

    }

    /**
     * Estado do atributo tamanhoMaximoFila e tamanhoMedioFila.
     * Estes atributos armazenam a media de tamanho da fila de atendimento e qual o tamanho maximo
     * da fila que foi atingido durante o processamento da simuacao.
     * 
     * @param tamanhos Uma lista com o tamanho da fila registrado a cada ciclo de simulacao
     *                  do processamento. <code>List Integer </code>.
     * @return <code>Estatistica</code> Instancia do presente objeto para definicoes
     *          padrao builder.
     */
    public Estatistica setTamanhosFila(List<Integer> tamanhos) {

        this.tamanhoMaximoFila = Collections.max(tamanhos);
        
        double sum = 0;

        for (Integer tamanho : tamanhos) {
            
            sum += tamanho;

        }

        this.tamanhoMedioFila = (sum/(this.atendimentosConcluidos.size()));

        return this;

    }

    /**
     * Metodo modificador do atributo tempoMedioFila.
     * Este atributo armazena uma media do tempo de espera na fila
     * de atendimento ate que cada evento (atendimento) seja processado
     * pela simulacao.
     * 
     */
    public void setTempoMedioFila() {

        double sum = 0;

        for (Atendimento atendimento : this.atendimentosConcluidos) {
            
            sum += atendimento.getTempoEspera();

        }

        sum /= this.atendimentosConcluidos.size();

        this.tempoMedioFila = sum;

    }

    /**
     * Metodo modificador do estado do atributo tempoMedioEleitor.
     * Este atributo armazena uma media da media do tempo de espera
     * na fila do processo de simulacao para cada tipo de eleitor presente
     * no sistema: eletior comum e eleitor preferencial.
     * 
     * @return <code>Estatistica</code> Instancia do presente objeto para definicoes
     *          padrao builder.
     */
    public Estatistica setTempoMedioEleitor() {

        double sum = 0;

        for (Atendimento atendimento : this.atendimentosConcluidos) {
            
            sum += atendimento.getTempoAtendimento();

        }

        this.tempoMedioTipoEleitor = (sum / this.atendimentosConcluidos.size());
        
        return this;

    }

    /**
     * Metodo acessador do proprio objeto.
     * Padrao builder.
     * @return <code>Estatistica</code> Instancia do presente objeto para definicoes
     *          padrao builder.
     */
    public Estatistica getInstance() {

        return this;

    }

    /**
     * Metodo acessador do estado do atributo tempoTotal.
     * 
     * @return <code>integer</code> Estado do atributo tempoTotal.
     */
    public int getTempoTotal() {

        return this.tempoTotal;

    }

    /**
     * Metodo acessador do estado do atributo tamanhoMaximoFila
     * 
     * @return <code>integer</code> estado do atributo tamanhoMaximoFila.
     */
    public int getTamanhoMaximoFila() {

        return this.tamanhoMaximoFila;

    }

    /**
     * Metodo acessador do estado do atributo quantidadeEventos.
     * 
     * @return <code>integer</code> estado do atributo quantidadeEventos.
     */
    public int getQuantidadeEventos() {

        return this.quantidadeEventos;

    }

    /**
     * Metodo acessador do estado do atributo tamanhoMedioFila.
     * 
     * @return <code>double</code> estado do atributo tamanhoMedioFila.
     */
    public double getTamanhoMedioFila() {

        return this.tamanhoMedioFila;

    }

    /**
     * Metodo acessador do estado do atributo tempoMedioEleitor.
     * 
     * @return <code>double</code> estado do atributo tempoMedioEleitor.
     */
    public double getTempoMedioEleitor() {

        return this.tempoMedioTipoEleitor;

    }

    /**
     * Metodo acessador do estado do atributo tempoMedioFila.
     * 
     * @return <code>double</code> estado do atributo tempoMedioFila.
     */
    public double getTempoMedioFila() {

        return this.tempoMedioFila;

    }

    /**
     * Metodo sobrescrito de Object.
     * Descreve de forma textual o estado o objeto.
     * 
     * @return <code>String</code> Descricao textual do estado do objeto.
     */
    @Override
    public String toString() {
        return "Estatistica {\n " +
            "atendimentos_concluidos: \n\t" + atendimentosConcluidos + "\n" +
            "quantidade_eventos_atendidos: " + quantidadeEventos + ",\n" +
            "tamanho_maximo_fila: " + tamanhoMaximoFila + ",\n" + 
            "tamanho_medio_fila: " + tamanhoMedioFila + ",\n"+
            "tempo_medio_fila: " + tempoMedioFila + ",\n" +
            "tempo_medio_tipo_eleitor: " + tempoMedioTipoEleitor + ",\n" +
            "tempoTotal: " + tempoTotal + "\n}";
    }


}