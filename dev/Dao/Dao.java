package Dao;

import java.io.File;
import java.util.List;
import Core.Atendente;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.util.List;
import java.util.ArrayList;
import Core.Eleitor;

public class Dao {

    private List<Eleitor> eleitores;
    private List<Atendente> atendentes;

    public Dao() {

        this.eleitores  = new ArrayList<Eleitor>();
        this.atendentes = new ArrayList<Atendente>();

    }

    public void read() {


    }

    public List<Eleitor> getEleitores() {

        return this.eleitores;

    }
    
    public List<Atendente> getAtendentes() {

        return this.atendentes;

    }

}