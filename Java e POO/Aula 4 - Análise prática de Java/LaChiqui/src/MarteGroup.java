import Convidados.Convidados;
import Fogos.FogosArtificio;

import java.util.List;

public class MarteGroup {
    List<FogosArtificio> listaFogos;
    List<Convidados> listaConvidados;

    public MarteGroup(List<FogosArtificio> listaFogos, List<Convidados> listaConvidados) {
        this.listaFogos = listaFogos;
        this.listaConvidados = listaConvidados;
    }

    public List<FogosArtificio> getListaFogos() {
        return listaFogos;
    }

    public void setListaFogos(List<FogosArtificio> listaFogos) {
        this.listaFogos = listaFogos;
    }

    public List<Convidados> getListaConvidados() {
        return listaConvidados;
    }

    public void setListaConvidados(List<Convidados> listaConvidados) {
        this.listaConvidados = listaConvidados;
    }

    public void explodirFogos() {
        this.listaFogos.forEach(fogos -> fogos.explodir());
    }

    public void partirBolo() {
        this.listaConvidados.forEach(convidado -> convidado.degustarBolo());
    }
}
