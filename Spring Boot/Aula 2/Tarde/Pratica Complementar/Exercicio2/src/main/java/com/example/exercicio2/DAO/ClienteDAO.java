package com.example.exercicio2.DAO;

import com.example.exercicio2.DTO.ClienteDTO;
import com.example.exercicio2.Entities.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    List<Cliente> clientes = new ArrayList<>();

    public ClienteDAO() {
    }

    public void adicionar (Cliente cliente) {
        this.clientes.add(cliente);
    }

    public Cliente retonaFuncionarioPorId (long id) {
        return this.clientes.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    public List<Cliente> getClientes() {
        return clientes;
    }
}
