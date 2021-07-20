package com.example.exercicio1.Entity;

import java.util.List;

public class Mesa {
    private long id;
    private List<Pedido> pedidos;

    public Mesa(long id, List<Pedido> pedidos) {
        this.id = id;
        this.pedidos = pedidos;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }


}
