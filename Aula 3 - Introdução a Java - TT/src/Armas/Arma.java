package Armas;

import java.util.Comparator;

public abstract class Arma{
    private String nome;
    private Double dano;

    public abstract void atacar();

    public Arma(String nome, Double dano) {
        this.nome = nome;
        this.dano = dano;
    }

    public Double getDano() {
        return dano;
    }

    public void setDano(Double dano) {
        this.dano = dano;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
