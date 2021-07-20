package com.example.exercicio2.DTO;

import com.example.exercicio2.DAO.ClienteDAO;
import com.example.exercicio2.Entities.Cliente;
import com.example.exercicio2.Entities.Pedido;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ClienteDTO {
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private List<Pedido> pedidos;
    private BigDecimal valorTotal;

    public ClienteDTO(String nome, String cpf, String email, String telefone, List<Pedido> pedidos, BigDecimal valorTotal) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.pedidos = pedidos;
        this.valorTotal = valorTotal;
    }

    public static Cliente converte(ClienteDTO cliente, ClienteDAO dao) {
        return new Cliente(dao.getClientes().size() + 1, cliente.getNome(), cliente.getCpf(), cliente.getEmail(), cliente.getTelefone(), cliente.getPedidos());
    }

    public static ClienteDTO converte(Cliente cliente) {
        return new ClienteDTO(cliente.getNome(), cliente.getCpf(), cliente.getEmail(), cliente.getTelefone(), cliente.getPedidos(), cliente.getValorTotal());
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }
    public BigDecimal getValorTotal() {
        return valorTotal;
    }

}
