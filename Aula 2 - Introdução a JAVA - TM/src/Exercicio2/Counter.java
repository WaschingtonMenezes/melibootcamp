package Exercicio2;
/*
Crie uma classe Counter (sim, contador de programação) com métodos que permitam
aumentar e diminuir seu valor. A classe conterá um construtor padrão, um construtor
com parâmetros, um construtor de cópia e os setters e getters correspondentes (métodos de acesso).
*/
public class Counter {
    private int count;

    public Counter() {
        this.count = 0;
    }

    public Counter(int count) {
        this.count = count;
    }

    public Counter(Counter count) {
        this.count = count.count;
    }

    public void Incrementar(){
        this.count++;
    }

    public void Decrementar(){
        this.count--;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
