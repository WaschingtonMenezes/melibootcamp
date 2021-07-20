package com.example.exercicio1.DTO;

import com.example.exercicio1.Entity.Mesa;
import com.example.exercicio1.Entity.Pedido;
import com.example.exercicio1.Entity.Prato;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MesaDTO {
    private long id;
    private List<Pedido> listaPedidos;
    private BigDecimal totalConsumido;

    public MesaDTO(long id, List<Pedido> listaPedidos, BigDecimal totalConsumido) {
        this.id = id;
        this.listaPedidos = listaPedidos;
        this.totalConsumido = totalConsumido;
    }

    public static MesaDTO obterItens(Mesa mesa) {
        BigDecimal totalConsumido = mesa.getPedidos().stream().map(p -> p.getTotalConsumido()).reduce((x, y) -> x.add(y)).get();
        return new MesaDTO(mesa.getId(), mesa.getPedidos(), totalConsumido);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Pedido> getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPratos(List<Pedido> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }

    public BigDecimal getTotalConsumido() {
        return totalConsumido;
    }

    public void setTotalConsumido(BigDecimal totalConsumido) {
        this.totalConsumido = totalConsumido;
    }
}
