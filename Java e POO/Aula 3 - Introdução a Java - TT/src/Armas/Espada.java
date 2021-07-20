package Armas;

import Armas.Arma;

import java.util.Random;

public class Espada extends Arma {
    public Espada(String nome, Double dano) {
        super(nome, dano);
    }

    @Override
    public void atacar() {
        System.out.println("Ataque com a " + this.getNome() + " causa " + this.getDano() * new Random().nextInt(5) + " de dano");
    }
}
