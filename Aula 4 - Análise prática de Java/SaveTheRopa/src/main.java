import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String args[]) {
        List<Vestuario> vestuario = new ArrayList<>();
        vestuario.add(new Vestuario("Adidas", "Air Max"));
        vestuario.add(new Vestuario("Lacoste", "Gola Polo"));

        GuardaRoupa guardaRoupa = new GuardaRoupa();
        int id = guardaRoupa.guardarVestuarios(vestuario);

        guardaRoupa.mostrarVestuarios();

        guardaRoupa.devolverVestuarios(id);

        guardaRoupa.mostrarVestuarios();
    }
}
