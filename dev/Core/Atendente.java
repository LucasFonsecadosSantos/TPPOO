package Core;

public abstract class Atendente {

    private String nome;
    private int tempo;

    public Atendente(String nome, int tempo) {

        this.setNome(nome);
        this.setTempo(tempo);

    }

    public String getNome() {

        return nome;
        
    }

    private void setNome(String nome) {

        this.nome = nome;

    }

    public int getTempo() {

        return tempo;

    }

    private void setTempo(int tempo) {

        this.tempo = tempo;

    }

    @Override
    public String toString() {
        
        return "Atendente [nome=" + nome + ", tempo=" + tempo + "]";
        
    }

    
    
}