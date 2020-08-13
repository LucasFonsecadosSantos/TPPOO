package Core;

import java.util.List;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Comparator;
import Dao.Dao;
import Model.AtendimentoJustificativa;
import Model.AtendimentoVotar;

/**
 * [SIMULADOR DE ATENDIMENTO EM ZONA ELEITORAL - PPOO Projeto Pratico]
 * 
 * A presente classe e repsonsavel pela execucao do processo e logica de
 * simulacao.
 * 
 * @author Lucas Fonseca dos Santos
 * @author Marco Aurelio Ferreira de Sousa
 * 
 */
public class Simulador {

    private PriorityQueue<Atendimento> atendimentos;
    private List<Atendente> atendentes;
    private Dao dao;

    /**
     * Construtor da classe.
     * 
     * @param inputPath Caminho do arquivo de entrada passado por argumento.
     */
    public Simulador(String inputPath) {

        Comparator<Atendimento> atendimentoSorter = Comparator.comparing(Atendimento::getTempo);

        this.atendimentos = new PriorityQueue<Atendimento>(atendimentoSorter);
        this.atendentes = new ArrayList<Atendente>();
        this.dao = new Dao();
        this.carregarDados(inputPath);

    }

    /**
     * Metodo responsavel pela execucao do processamento da
     * simulacao. Aqui jaz toda a logica do processamento.
     */
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

    /**
     * Metodo responsavel pela atualizacao do tempo de espera na fila
     * em cada um dos eventos de atendimento.
     */
    private void atualizaTempoEsperaFila() {

        for (Atendimento atendimento : this.atendimentos) {
                
            atendimento.atualizaTempoEspera();

        }

    }

    /**
     * Metodo responsavel pela gerecao da saida do processamento.
     * 
     * @param estatistica   Classe com informacoes e metricas colhidas durante
     *                      o processamento.
     */
    private void gerarSaidas(Estatistica estatistica) {

        this.dao.output(estatistica.toString());

    }

    /**
     * Metodo responsavel pela leitura do arquivo de entrada e carregamento das
     * listas de informacoes utilizadas pelo processamento da simuacao.
     * 
     * @param inputPath <code>String</code> caminho do arquivo de entrada.
     */
    private void carregarDados(String inputPath) {

        this.dao.read(inputPath);
        this.atendentes = this.dao.getAtendentes();
        this.carregarAtendimentos(this.dao.getEleitores());

    }

    /**
     * Metodo responsavel pelo carregamento e construcao dos eventos de atendimento.
     * 
     * @param eleitores <code>List Eleitor</code> lista de eleitores.
     */
    private void carregarAtendimentos(List<Eleitor> eleitores) {

        for (Eleitor eleitor : eleitores) {

            this.atendimentos.add((eleitor.getTipoAtendimento().equals("votar")) ? new AtendimentoVotar(eleitor) : new AtendimentoJustificativa(eleitor));

        }

    }

}