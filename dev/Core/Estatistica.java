package Core;

import java.util.List;
import java.util.Collections;

public class Estatistica {

    private int                 tempoTotal;
    private int                 quantidadeEventos;
    private double              tempoMedioFila;
    private double              tamanhoMedioFila;
    private int                 tamanhoMaximoFila;
    private double              tempoMedioTipoEleitor;
    private List<Atendimento>   atendimentosConcluidos;

    public Estatistica() {

    }

    public Estatistica setTempoTotal(int tempoTotal) {

        this.tempoTotal = tempoTotal;
        return this;

    }

    public Estatistica setQuantidadeEventos(int quantidadeEventos) {

        this.quantidadeEventos = quantidadeEventos;
        return this;

    }

    public Estatistica setAtendimentosConcluidos(List<Atendimento> atendimentosConcluidos) {

        this.atendimentosConcluidos = atendimentosConcluidos;
        this.setTempoMedioFila();
        return this;

    }

    public Estatistica setTamanhosFila(List<Integer> tamanhos) {

        this.tamanhoMaximoFila = Collections.max(tamanhos);
        
        double sum = 0;

        for (Integer tamanho : tamanhos) {
            
            sum += tamanho;

        }

        this.tamanhoMedioFila = (sum/(this.atendimentosConcluidos.size()));

        return this;

    }

    public void setTempoMedioFila() {

        double sum = 0;

        for (Atendimento atendimento : this.atendimentosConcluidos) {
            
            sum += atendimento.getTempoEspera();

        }

        sum /= this.atendimentosConcluidos.size();

        this.tempoMedioFila = sum;

    }

    public Estatistica setTempoMedioEleitor() {

        double sum = 0;

        for (Atendimento atendimento : this.atendimentosConcluidos) {
            
            sum += atendimento.getTempoAtendimento();

        }

        this.tempoMedioTipoEleitor = (sum / this.atendimentosConcluidos.size());
        
        return this;

    }

    public Estatistica getInstance() {

        return this;

    }

    public int getTempoTotal() {

        return this.tempoTotal;

    }

    public int getTamanhoMaximoFila() {

        return this.tamanhoMaximoFila;

    }

    public int getQuantidadeEventos() {

        return this.quantidadeEventos;

    }

    public double getTamanhoMedioFila() {

        return this.tamanhoMedioFila;

    }

    public double getTempoMedioEleitor() {

        return this.tempoMedioTipoEleitor;

    }

    public double getTempoMedioFila() {

        return this.tempoMedioFila;

    }

    @Override
    public String toString() {
        return "Estatistica [atendimentosConcluidos=" + atendimentosConcluidos + ", quantidadeEventos="
                + quantidadeEventos + ", tamanhoMaximoFila=" + tamanhoMaximoFila + ", tamanhoMedioFila="
                + tamanhoMedioFila + ", tempoMedioFila=" + tempoMedioFila + ", tempoMedioTipoEleitor="
                + tempoMedioTipoEleitor + ", tempoTotal=" + tempoTotal + "]";
    }


}