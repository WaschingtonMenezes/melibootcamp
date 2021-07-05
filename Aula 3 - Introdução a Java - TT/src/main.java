import Armas.ArcoFlexa;
import Armas.Arma;
import Armas.Cajado;
import Armas.Espada;
import Personagem.Classe;
import Personagem.PersonagemPrincipal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class main {
    public static void main(String Args[]) {
        List<Arma> armas = new ArrayList<>();
        armas.add(new Espada("Escalibur", 10.5));
        armas.add(new Cajado("Majorn Ju", 9.0));
        armas.add(new Cajado("Redix Mágico", 9.0));
        armas.add(new ArcoFlexa("Arco Simples", 2.0));

        Collections.sort(armas, new Comparator<Arma>() {
            @Override
            public int compare(Arma o1, Arma o2) {
                return o1.getNome().compareTo(o2.getNome());
            }
        });

        PersonagemPrincipal personagem = new PersonagemPrincipal("Was", Classe.ARQUEIRO);

        for (Arma arma: armas) {
            personagem.setSlotArma(arma);
            personagem.getSlotArma().atacar();
        }
    }
}
