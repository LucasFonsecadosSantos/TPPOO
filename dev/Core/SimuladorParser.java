package Core;

import java.util.List;
import java.util.ArrayList;
import Model.AtendenteExperiente;
import Model.AtendenteIniciante;
import Model.EleitorComum;
import Model.EleitorPreferencial;

public class SimuladorParser {

    public SimuladorParser() {}

    public static List<Atendente> getAtendentes(String data) {

        List<Atendente> atendentes = new ArrayList<Atendente>();

        data = data.trim();

        String[] tokens = data.split("\n");
        boolean atendenteFlag = false;

        for (String row : tokens) {
            
            if (!row.equals("")) {
            
                if (row.equals("[INICIO-ATENDENTE]")) {

                    atendenteFlag = true;
                    continue;

                } else if (row.equals("[FIM-ATENDENTE]")) {

                    atendenteFlag = false;
                    continue;

                }

                if (atendenteFlag) {

                    String[] atendenteTokens = row.split(",");                
                    atendentes.add((atendenteTokens[1].toLowerCase().equals("experiente")) ? new AtendenteExperiente(atendenteTokens[0]) : new AtendenteIniciante(atendenteTokens[0]));

                }
            
            }

        }

        return atendentes;

    }

    public static List<Eleitor> getEleitores(String data) {

        List<Eleitor> eleitores = new ArrayList<Eleitor>();

        data = data.trim();

        String[] tokens = data.split("\n");
        boolean eleitorFlag = false;

        for (String row : tokens) {
            
            if (!row.equals("")) {
            
                if (row.equals("[INICIO-ELEITOR]")) {

                    eleitorFlag = true;
                    continue;

                } else if (row.equals("[FIM-ELEITOR]")) {

                    eleitorFlag = false;
                    continue;

                }

                if (eleitorFlag) {

                    String[] eleitorTokens = row.split(",");
                    
                    eleitores.add((eleitorTokens[2].toLowerCase().equals("prioritario")) ? new EleitorPreferencial(eleitorTokens[0],Integer.parseInt(eleitorTokens[1]), eleitorTokens[3]) : new EleitorComum(eleitorTokens[0], Integer.parseInt(eleitorTokens[1]), eleitorTokens[3]));

                }
            
            }

        }

        return eleitores;

    }

}