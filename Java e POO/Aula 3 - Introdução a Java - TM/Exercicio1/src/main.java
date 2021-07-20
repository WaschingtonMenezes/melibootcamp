import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main (String args[]) {
        Pessoa p1 = new Pessoa("Aaria", "14465723741");
        Pessoa p2 = new Pessoa("Pedro", "14465723741");
        Pessoa p3 = new Pessoa("Waschington", "14465723741");
        Pessoa p4 = new Pessoa("Carlos", "14465723741");
        Pessoa[] listaPessoas = {p1, p2, p3, p4};

        System.out.println("Antes do Sort:\n");
        for (Pessoa p : listaPessoas) {
            System.out.println(p.getNome());
        }

        SortUtil.sort(listaPessoas);

        System.out.println("\n\nDepois do Sort:\n");
        for (Pessoa p : listaPessoas) {
            System.out.println(p.getNome());
        }
    }
}
