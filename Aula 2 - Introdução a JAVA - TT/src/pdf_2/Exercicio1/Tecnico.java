package pdf_2.Exercicio1;

import java.math.BigDecimal;

public class Tecnico extends FuncionarioCLT{
    private double metaBatida;
    public Tecnico(double metaBatida) {
        super(3200.00, 5.0, 40.0);
        this.metaBatida = metaBatida;
    }

    public double getMetaBatida() {
        return metaBatida;
    }

    public void setMetaBatida(double metaBatida) {
        this.metaBatida = metaBatida;
    }

    @Override
    public double pagarSalario() {
        return this.getSalarioBase() + ((getBonificacao() / 100) * this.metaBatida);
    }
}
