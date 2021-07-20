package com.example.exercicio2.Entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private long id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private List<Pedido> pedidos = new ArrayList<>();

    public Cliente(long id, String nome, String cpf, String email, String telefone, List<Pedido> pedidos) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.pedidos = pedidos;
    }

    public BigDecimal getValorTotal() {
        return pedidos.stream().map(pedido -> pedido.getValorTotal()).reduce((x, y) -> x.add(y)).get();
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
