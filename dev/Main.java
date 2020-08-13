import Core.Simulador;

/**
 * [SIMULADOR DE ATENDIMENTO EM ZONA ELEITORAL - PPOO Projeto Pratico]
 * 
 * Processador de simulacao para uma fila de atendimentos em uma zona
 * eleitoral.
 * 
 * @author Lucas Fonseca dos Santos
 * @author Marco Aurelio Ferreira de Sousa
 * 
 */

public class Main {

    public static void main(String ...args) {

        Simulador simulador = new Simulador(args[0]);
        simulador.executar();

    }

}