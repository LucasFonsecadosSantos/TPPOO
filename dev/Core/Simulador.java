package Core;

import java.util.List;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Comparator;
import Dao.Dao;
import Model.AtendimentoJustificativa;
import Model.AtendimentoVotar;

public class Simulador {

    private PriorityQueue<Atendimento> atendimentos;
    private List<Atendente> atendentes;
    private Dao dao;

    public Simulador(String inputPath) {

        Comparator<Atendimento> atendimentoSorter = Comparator.comparing(Atendimento::getTempo);

        this.atendimentos = new PriorityQueue<Atendimento>(atendimentoSorter);
        this.atendentes = new ArrayList<Atendente>();
        this.dao = new Dao();
        this.carregarDados(inputPath);

    }

    public void executar() {

        Atendimento atendimentoAtual;
        List<Atendimento> concluidos    = new ArrayList<Atendimento>();
        List<Integer> tamanhoAtualFila  = new ArrayList<Integer>();
        int tempo = 0;
        int l1 = 0;
        int l2 = 0;

        while (!this.atendimentos.isEmpty()) {
            l1++;
            for (Atendente atendente : this.atendentes) {
                l2++;
                if (atendente.livre()) {
                    
                    if (!this.atendimentos.isEmpty()) {
                    
                        atendimentoAtual = this.atendimentos.poll();
                        //System.out.println(atendimentoAtual);
                        //System.out.println("L1: " + l1 + " / L2: " + l2 + " ATENDENTE: " + atendente.getNome() + " ATENDIMENTO: " + atendimentoAtual);
                        System.out.println("Processando...");
                        atendente.setTempoEstado(atendimentoAtual.getTempo());
                        atendimentoAtual.setTempoAtendimento(atendente.getTempoEstado());
                        concluidos.add(atendimentoAtual);
                    
                    } else {

                        break;

                    }

                } else {

                    atendente.atualizaTempoEstado();

                }

            }

            ++tempo;
            this.atualizaTempoEsperaFila();
            tamanhoAtualFila.add(this.atendimentos.size());
            System.out.println("PROCESSAMENTO COMPLETO!");

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