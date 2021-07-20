package Exercicio4;
/*
*  Exercício 4
Crie uma classe Fracao com métodos necessários para adicionar, subtrair, multiplicar e dividir frações.
* Todos os métodos devem ser sobrecarregados para que também possam ser usados ​​para operar entre
* frações e números inteiros (por exemplo: ⅗ + 2 ou ⅝ * 4).
* */

public class Fracao {
    private int numerador;
    private int denominador;

    public Fracao() {
    }

    public Fracao(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }

    public void adicionar (Fracao j) {
        if (this.denominador == j.denominador) {
            this.numerador += j.numerador;
            return;
        }

        int mmc = MMC(this.denominador, j.denominador);
        this.numerador = (mmc / this.denominador) * this.numerador;
        int temp = (mmc / j.denominador) * j.numerador;
        this.numerador += temp;
        this.denominador = mmc;
    }
    public void adicionar (int n) {
        Fracao j = new Fracao(n, 1);
        adicionar(j);
    }

    public void subtrair (Fracao j) {
        if (this.denominador == j.denominador) {
            this.numerador -= j.numerador;
            return;
        }

        int mmc = MMC(this.denominador, j.denominador);
        this.numerador = (mmc / this.denominador) * this.numerador;
        int temp = (mmc / j.denominador) * j.numerador;
        this.numerador -= temp;
        this.denominador = mmc;
    }
    public void subtrair (int n) {
        Fracao j = new Fracao(n, 1);
        subtrair(j);
    }

    public void multiplicar (Fracao j) {
        this.numerador *= j.numerador;
        this.denominador *= j.denominador;
    }
    public void multiplicar (int n) {
        Fracao j = new Fracao(n, 1);
        multiplicar(j);
    }

    public void dividir (Fracao j) {
        this.numerador *= j.denominador;
        this.denominador *= j.numerador;
    }
    public void dividir (int n) {
        Fracao j = new Fracao(n, 1);
        dividir(j);
    }


    @Override
    public String toString() {
        if (this.numerador % this.denominador == 0) {
            return Integer.toString(this.numerador / this.denominador);
        }
        return this.numerador + "/" + this.denominador;
    }

    private int MMC (int n1, int n2) {
        int resto;
        int a = n1;
        int b = n2;
        while (b != 0) {
            resto = a % b;
            a = b;
            b = resto;
        }
        return (n1 * n2) / a;
    }
}
