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

public class Dao {

    private List<Eleitor> eleitores;
    private List<Atendente> atendentes;

    public Dao() {

        this.eleitores  = new ArrayList<Eleitor>();
        this.atendentes = new ArrayList<Atendente>();

    }

    public void output(String outData) {

        File file = new File("data/out.txt");

        try {

            file.createNewFile();
        
        } catch (Exception e) {

        }

        try (FileWriter fw = new FileWriter(file)) {

            fw.write(outData);
        
        } catch (Exception ex) {

            System.out.println("Ops: Parece que tivemos uma excecao na escrita dos resultados da simulacao: " + ex.getMessage());

        }

    }

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

    public List<Eleitor> getEleitores() {

        return this.eleitores;

    }
    
    public List<Atendente> getAtendentes() {

        return this.atendentes;

    }

}