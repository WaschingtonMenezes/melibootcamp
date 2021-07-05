package pdf_2.Exercicio1;

import java.math.BigDecimal;

public class Diretor extends FuncionarioCLT{
    private double lucros;
    public Diretor(double lucros) {
        super(15000.00, null, null);
        this.lucros = lucros;
    }

    @Override
    public double pagarSalario() { return this.getSalarioBase() + (0.03 * this.lucros); }
}
