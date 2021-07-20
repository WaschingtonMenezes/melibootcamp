package br.com.crud.crud.Entity;

public class Funcionario {
    private long id;
    private String nome;
    private String cpf;

    public Funcionario(long id, String nome, String cpf) {
        super();
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
    }

    public Funcionario() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
