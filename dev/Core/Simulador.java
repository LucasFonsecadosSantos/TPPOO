package Core;

import java.util.List;
import java.util.PriorityQueue;
import java.util.ArrayList;
import Dao.Dao;
import Model.AtendimentoJustificativa;
import Model.AtendimentoVotar;

public class Simulador {

    private PriorityQueue<Atendimento> atendimentos;
    private List<Atendente> atendentes;
    private Dao dao;

    public Simulador(String inputPath) {

        this.atendimentos = new PriorityQueue<Atendimento>();
        this.atendentes = new ArrayList<Atendente>();
        this.dao = new Dao();
        this.carregarDados(inputPath);

    }

    public void executar() {

        Atendimento atendimentoAtual;
        List<Atendimento> concluidos    = new ArrayList<Atendimento>();
        List<Integer> tamanhoAtualFila  = new ArrayList<Integer>();

        int tempo = 0;

        while (!this.atendimentos.isEmpty()) {

            for (Atendente atendente : this.atendentes) {
                
                if (atendente.livre()) {

                    atendimentoAtual = this.atendimentos.poll();
                    atendente.setTempoEstado(atendimentoAtual.getTempo());
                    atendimentoAtual.setTempoAtendimento(atendente.getTempoEstado());
                    concluidos.add(atendimentoAtual);

                } else {

                    atendente.atualizaTempoEstado();

                }

            }

            ++tempo;
            this.atualizaTempoEsperaFila();
            tamanhoAtualFila.add(this.atendimentos.size());

        }

        this.gerarSaidas(
            
            new Estatistica()
                .setTempoTotal(tempo)
                .setQuantidadeEventos(concluidos.size())
                .setAtendimentosConcluidos(concluidos)
                .setTamanhosFila(tamanhoAtualFila)
                .setTempoMedioEleitor()
                .getInstance()

        );

    }

    private void atualizaTempoEsperaFila() {

        for (Atendimento atendimento : this.atendimentos) {
                
            atendimento.atualizaTempoEspera();

        }

    }

    private void gerarSaidas(Estatistica estatistica) {

        this.dao.output(estatistica.toString());

    }

    private void carregarDados(String inputPath) {

        this.dao.read(inputPath);
        this.atendentes = this.dao.getAtendentes();
        this.carregarAtendimentos(this.dao.getEleitores());

    }

    private void carregarAtendimentos(List<Eleitor> eleitores) {

        for (Eleitor eleitor : eleitores) {

            this.atendimentos.add((eleitor.getTipoAtendimento().equals("votar")) ? new AtendimentoVotar(eleitor) : new AtendimentoJustificativa(eleitor));

        }

    }

}