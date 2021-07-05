import Convidados.Convidados;
import Convidados.ConvidadosMeli;
import Convidados.ConvidadosStandard;
import Fogos.FogosArtificio;
import Fogos.FogosIndividuais;
import Fogos.PacoteFogos;

import java.util.ArrayList;
import java.util.List;

public class main {
   public static void main(String args[]) {
       List<FogosArtificio> fogos = new ArrayList<>();
        fogos.add(new FogosIndividuais());
        fogos.add(new PacoteFogos(
                new ArrayList<>() {
                    {
                        add(new FogosIndividuais());
                        add(new FogosIndividuais());
                        add(new FogosIndividuais());
                        add(new PacoteFogos(
                                new ArrayList<>() {
                                    {
                                        add(new FogosIndividuais());
                                        add(new FogosIndividuais());
                                        add(new FogosIndividuais());
                                    }
                                })
                        );
                    }
                }));

        List<Convidados>  listaConvidados = new ArrayList<>(){
            {
                add(new ConvidadosMeli());
                add(new ConvidadosStandard());
                add(new ConvidadosMeli());
            }
        };

        MarteGroup marteGroup = new MarteGroup(fogos, listaConvidados);
        marteGroup.explodirFogos();
        marteGroup.partirBolo();
       }
}
