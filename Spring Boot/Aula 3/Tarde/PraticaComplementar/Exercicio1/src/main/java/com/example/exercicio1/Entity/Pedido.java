package com.example.exercicio1.Entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private long id;
    private long mesaId;
    private List<Prato> pratos = new ArrayList<>();

    public Pedido(long id, long mesaId, List<Prato> pratos) {
        this.id = id;
        this.mesaId = mesaId;
        this.pratos = pratos;
    }

    public BigDecimal getTotalConsumido(){
        return this.pratos.stream().map(p -> p.getPreco().multiply(BigDecimal.valueOf(p.getQuantidade()))).reduce((x, y) -> x.add(y)).get();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getMesaId() {
        return mesaId;
    }

    public void setMesaId(Long mesaId) {
        this.mesaId = mesaId;
    }

    public List<Prato> getPratos() {
        return pratos;
    }

    public void setPratos(List<Prato> pratos) {
        this.pratos = pratos;
    }
}
