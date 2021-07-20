package com.complementar.exercicio1.Entity;

import java.math.BigDecimal;

public class Mesa {
    private long id;
    private Pedido pedido;

    public Mesa(long id, Pedido pedido) {
        this.id = id;
        this.pedido = pedido;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
