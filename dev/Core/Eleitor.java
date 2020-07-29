package Core;

public abstract class Eleitor {

    private String nome;
    private int tituloEleitor;
    private int tempo;
    private int prioridade;
    private String tipoAtendimento;

    public Eleitor(String nome, int tituloEleitor, int tempo, int prioridade, String tipoAtendimento) {

        this.nome = nome;
        this.tituloEleitor = tituloEleitor;
        this.tempo = tempo;
        this.prioridade = prioridade;
        this.tipoAtendimento = tipoAtendimento;

    }


    public String getNome() {

        return this.nome;

    }

    public int getTituloEleitor() {

        return tituloEleitor;

    }

    public int getTempo() {

        return tempo;

    }

    public int getPrioridade() {

        return prioridade;

    }

    

    public String getTipoAtendimento() {

        return tipoAtendimento;

    }

    public void setTipoAtendimento(String tipoAtendimento) {

        this.tipoAtendimento = tipoAtendimento;
        
    }

    @Override
    public String toString() {
        return "Eleitor [nome=" + nome + ", prioridade=" + prioridade + ", tempo=" + tempo + ", tipoAtendimento="
                + tipoAtendimento + ", tituloEleitor=" + tituloEleitor + "]";
    }

    

    

}