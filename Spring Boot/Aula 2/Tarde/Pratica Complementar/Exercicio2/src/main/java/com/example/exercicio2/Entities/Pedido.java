package com.example.exercicio2.Entities;

import java.math.BigDecimal;
import java.util.List;

public class Pedido {
    private long id;
    private List<Produto> produtos;

    public Pedido(long id, List<Produto> produtos) {
        this.id = id;
        this.produtos = produtos;
    }

    public BigDecimal getValorTotal() {
        return this.produtos.stream().map(p -> p.getPreco().multiply(BigDecimal.valueOf(p.getQuantidade()))).reduce((x, y) -> x.add(y)).get();
    }

    public long getId() {
        return id;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
}
