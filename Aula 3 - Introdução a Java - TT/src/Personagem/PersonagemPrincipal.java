package Personagem;/*
Inicialmente vamos criar uma classe para o nosso personagem
principal. Esta deve ter nome, classe (guerreiro, mago,
arqueiro e o que mais a imaginação mandar) e nível, além
de possuir um slot para carregar uma arma.*/

import Armas.Arma;

public class PersonagemPrincipal{
    private String nome;
    private Classe classe;
    private int nivel = 0;
    private Arma slotArma;

    public PersonagemPrincipal(String nome, Classe classe, Arma slotArma) {
        this.nome = nome;
        this.classe = classe;
        this.slotArma = slotArma;
    }

    public PersonagemPrincipal() {
        this.nivel = 0;
    }

    public PersonagemPrincipal(String nome, Classe classe) {
        this.nome = nome;
        this.classe = classe;
        this.nivel = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public Arma getSlotArma() {
        return slotArma;
    }

    public void setSlotArma(Arma slotArma) {
        this.slotArma = slotArma;
    }
}
