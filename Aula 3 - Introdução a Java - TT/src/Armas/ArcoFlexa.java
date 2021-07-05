package Armas;

import java.util.Random;

public class ArcoFlexa extends Arma {
    public ArcoFlexa(String nome, Double dano) {
        super(nome, dano);
    }

    @Override
    public void atacar() {
        System.out.println("Ataque com " + this.getNome() + " causa " +  this.getDano() * new Random().nextInt(2) + " de dano");
    }
}
