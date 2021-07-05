import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String args[]) {
        List<Veiculo> listaVeiculos = new ArrayList<>();

        listaVeiculos.add(new Moto(100.1, 100.5, 20.5, "IAOP3541"));
        listaVeiculos.add(new Carro(120.1, 98.4, 18.5, "ARDF1041"));

        Corrida corrida = new Corrida(2000.0, 100000.00, "Evento Red Bull", 2, listaVeiculos);

        corrida.registrarCarro(100.5, 5000.1, 30.5, "OPDK2287");
        corrida.removerVeiculoPorPlaca("IAOP3541");

        corrida.socorrerCarro("ARDF1041");
        corrida.determinarVencedor();
    }
}
