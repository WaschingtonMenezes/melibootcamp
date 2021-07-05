import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRoupa {
    private Map<Integer, List<Vestuario>> dicionario = new HashMap<>();
    private Integer contador = 0;

    public Integer guardarVestuarios(List<Vestuario> listaDeVestuario){
        this.contador++;
        dicionario.put(this.contador, listaDeVestuario);
        return contador;
    }

    public void mostrarVestuarios(){
        if (dicionario.size() == 0) {
            System.out.println("Guarda roupas vazio");
            return;
        }

        for (Map.Entry<Integer, List<Vestuario>> lista: dicionario.entrySet()) {
            lista.getValue().forEach(vestuario -> System.out.println("Nº " + lista.getKey() + " - " + vestuario.toString()));
        }
    }

    public List<Vestuario> devolverVestuarios(Integer id){
        return this.dicionario.remove(id);
    }
}
