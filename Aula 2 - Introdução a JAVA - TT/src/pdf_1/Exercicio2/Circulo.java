package pdf_1.Exercicio2;

public class Circulo extends GeometricFigure{
    private Double raio;

    public Circulo(Double raio) {
        this.raio = raio;
    }

    @Override
    public double area() {
        double pi = 3.14;
        return pi * (raio * raio);
    }
}
