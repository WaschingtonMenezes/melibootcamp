package pdf_2.Exercicio1;

import java.math.BigDecimal;

public abstract class FuncionarioCLT {
    private Double salarioBase;
    private Double bonificacao;
    private Double jornada;

    public Double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(Double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public Double getBonificacao() {
        return bonificacao;
    }

    public void setBonificacao(Double bonificacao) {
        this.bonificacao = bonificacao;
    }

    public Double getJornada() {
        return jornada;
    }

    public void setJornada(Double jornada) {
        this.jornada = jornada;
    }

    public FuncionarioCLT(Double salarioBase, Double bonificacao, Double jornada) {
        this.salarioBase = salarioBase;
        this.bonificacao = bonificacao;
        this.jornada = jornada;
    }

    public abstract double pagarSalario();
}
