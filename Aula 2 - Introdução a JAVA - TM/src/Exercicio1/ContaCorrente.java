package Exercicio1;

import java.math.BigDecimal;

public class ContaCorrente {
    private BigDecimal saldo;
    private String nome;
    private String conta;

    public ContaCorrente() {
    }

    public ContaCorrente(ContaCorrente contaCorrente) {
        this.saldo = contaCorrente.saldo;
        this.nome = contaCorrente.nome;
        this.conta = contaCorrente.conta;
    }

    public ContaCorrente(BigDecimal saldo, String nome, String conta) {
        this.saldo = saldo;
        this.nome = nome;
        this.conta = conta;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public void deposito () {}
    public void saque () {}
    public void devolucao () {}
    public void transferencia () {}
}
