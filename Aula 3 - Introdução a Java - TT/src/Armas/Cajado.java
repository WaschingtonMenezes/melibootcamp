package Armas;

import Armas.Arma;

import java.util.Random;

public class Cajado extends Arma {
    public Cajado(String nome, Double dano) {
        super(nome, dano);
    }

    @Override
    public void atacar() {
        System.out.println("Ataque com o cajado " + this.getNome() + " causa " +  this.getDano() * new Random().nextInt(15) + " de dano");
    }
}
