package pdf_1.Exercicio2;

public class main {
    public static void main (String args[]) {
        GeometricFigure[] geometricFigures = { new Triangulo(10,8), new Circulo(2.2), new Retangulo(5,2)};
        System.out.println(Utilitario.areaMedia(geometricFigures));
    }
}
