package Core;

import java.lang.Comparable;

public abstract class Atendimento implements Comparable<Eleitor> {

    private Eleitor eleitor;
    private int tempo;
    private int tempoAtendimento;
    private int tempoEspera;

    public Atendimento(Eleitor eleitor, int tempo) {

        this.eleitor = eleitor;
        this.tempo = tempo;

    }

    public Eleitor getEleitor() {

        return eleitor;

    }

    public int getTempoAtendimento() {

        return tempoAtendimento;

    }

    public int getTempoEspera() {

        return tempoEspera;

    }

    @Override
    public String toString() {

        return "Atendimento [eleitor=" + eleitor + ", tempoAtendimento=" + tempoAtendimento + ", tempoEspera="
                + tempoEspera + "]";

    }

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