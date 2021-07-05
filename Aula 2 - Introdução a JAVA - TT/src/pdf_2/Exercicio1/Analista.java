package pdf_2.Exercicio1;

import java.math.BigDecimal;

public class Analista extends FuncionarioCLT{
    private double metaBatida;
    private double descansoRemunerado;

    public Analista(double metaBatida) {
        super(4000.00, 8.0, 40.0);
        this.metaBatida = metaBatida;
        this.descansoRemunerado = 4.0;
    }

    public double getMetaBatida() {
        return metaBatida;
    }

    public void setMetaBatida(double metaBatida) {
        this.metaBatida = metaBatida;
    }

    public double getDescansoRemunerado() {
        return descansoRemunerado;
    }

    public void setDescansoRemunerado(double descansoRemunerado) {
        this.descansoRemunerado = descansoRemunerado;
    }

    @Override
    public double pagarSalario() {
        return this.getSalarioBase() + ((getBonificacao() / 100) * this.metaBatida);
    }
}
