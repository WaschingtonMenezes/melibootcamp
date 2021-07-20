package pdf_1.Exercicio2;

public class Utilitario {
    public static double areaMedia (GeometricFigure arr []) {
        int count = 0;
        double area = 0;
        for (GeometricFigure figure : arr) {
            area += figure.area();
            count++;
        }
        return area / count;
    }
}
