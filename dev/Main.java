import Core.Simulador;

public class Main {

    public static void main(String ...args) {

        Simulador simulador = new Simulador(args[0]);
        simulador.executar();

    }

}