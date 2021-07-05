package Fogos;

import java.util.List;

public class PacoteFogos extends FogosArtificio{
    private List<FogosArtificio> pacoteFogos;

    public PacoteFogos(List<FogosArtificio> pacoteFogos) {
        this.pacoteFogos = pacoteFogos;
    }

    public List<FogosArtificio> getPacoteFogos() {
        return pacoteFogos;
    }

    public void setPacoteFogos(List<FogosArtificio> pacoteFogos) {
        this.pacoteFogos = pacoteFogos;
    }

    @Override
    public void explodir() {
        System.out.println("Explodindo pacote de fogos \n");
        for(FogosArtificio fogos : this.pacoteFogos) {
            fogos.explodir();
        }
        System.out.println("Fogos do pacote foram explodidos\n");
    }
}
