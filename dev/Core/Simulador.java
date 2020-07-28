package Core;

import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;
import Dao.Dao;
import Model.AtendimentoJustificativa;
import Model.AtendimentoVotar;

public class Simulador {

    private Queue<Atendimento> atendimentos;
    private List<Atendente> atendentes;
    private Dao dao;

    public Simulador() {

        this.atendimentos = new LinkedList<Atendimento>();
        this.atendentes = new ArrayList<Atendente>();
        this.dao = new Dao();
        this.carregarDados();

    }

    public void executar() {

        while () {
            
        }

    }

    private void carregarDados() {

        this.dao.read();
        this.atendentes = this.dao.getAtendentes();
        this.carregarAtendimentos(this.dao.getEleitores());

    }

    private void carregarAtendimentos(List<Eleitor> eleitores) {

        for (Eleitor eleitor : eleitores) {

            this.atendimentos.add((eleitor.getTipoAtendimento().equals("votar")) ? new AtendimentoVotar(eleitor) : new AtendimentoJustificativa(eleitor));

        }

    }

}