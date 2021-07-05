package pdf_2.Exercicio1;


public class Gerente extends FuncionarioCLT{
    private double metaBatida;
    private double descansoRemunerado;

    public Gerente(double metaBatida) {
        super(6000.00, 12.5, 36.0);
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
    public double pagarSalario() { return this.getSalarioBase() + ((getBonificacao() / 100) * this.metaBatida); }
}
