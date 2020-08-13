package Dao;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import Core.Atendente;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.util.List;
import java.util.ArrayList;
import Core.Eleitor;
import Core.SimuladorParser;

/**
 * [SIMULADOR DE ATENDIMENTO EM ZONA ELEITORAL - PPOO Projeto Pratico]
 * 
 * A presente classe e repsonsavel pelo acesso a camada de dados
 * persistidos.
 * 
 * @author Lucas Fonseca dos Santos
 * @author Marco Aurelio Ferreira de Sousa
 * 
 */
public class Dao {

    private List<Eleitor> eleitores;
    private List<Atendente> atendentes;

    /**
     * Construtor da classe.
     */
    public Dao() {

        this.eleitores  = new ArrayList<Eleitor>();
        this.atendentes = new ArrayList<Atendente>();

    }

    /**
     * Metodo responsavel pelo acesso de saida/escrita de dados.
     * 
     * @param outData <code>String</code> informacao textual de saida.
     */
    public void output(String outData) {

        File file = new File("data/out.txt");

        try {

            file.getParentFile().mkdirs();
            file.createNewFile();
        
        } catch (Exception e) {

        }

        try (FileWriter fw = new FileWriter(file)) {

            fw.write(outData);
        
        } catch (Exception ex) {

            System.out.println("Ops: Parece que tivemos uma excecao na escrita dos resultados da simulacao: " + ex.getMessage());

        }

    }

    /**
     * Metodo responsavel pelo acesso de entrada/leitura de dados.
     * 
     * @param filePath <code>String</code> caminho do arquivo de entrada. 
     */
    public void read(String filePath) {

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {

                sb.append(line).append("\n");
                line = br.readLine();

            }

            this.eleitores  = SimuladorParser.getEleitores(sb.toString());
            this.atendentes = SimuladorParser.getAtendentes(sb.toString());

        } catch (Exception e) {

            System.out.println("Ops: Parece que tivemos uma excecao na leitura dos resultados da simulacao: " + e.getMessage());

        }

    }

    /**
     * Metodo acessador do atributo eleitores, construido a partir
     * dos dados lidos.
     * 
     * @return <code>List eleitor</code> lista de eleitores.
     */
    public List<Eleitor> getEleitores() {

        return this.eleitores;

    }
    
    /**
     * Metodo acessador do atributo atendentes. construido a partir
     * dos dados lidos.
     * 
     * @return <code>List atendente</code> lista de atendentes.
     */
    public List<Atendente> getAtendentes() {

        return this.atendentes;

    }

}