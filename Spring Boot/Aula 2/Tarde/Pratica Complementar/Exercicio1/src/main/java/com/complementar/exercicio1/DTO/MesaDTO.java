package com.complementar.exercicio1.DTO;

import com.complementar.exercicio1.Entity.Mesa;
import com.complementar.exercicio1.Entity.Pedido;
import com.complementar.exercicio1.Entity.Prato;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MesaDTO {
    private long id;
    private List<Prato> listaPratos = new ArrayList<>();
    private BigDecimal totalConsumido;

    public MesaDTO(long id, List<Prato> listaPratos, BigDecimal totalConsumido) {
        this.id = id;
        this.listaPratos = listaPratos;
        this.totalConsumido = totalConsumido;
    }

    public static MesaDTO obterItens(Mesa mesa) {
        return new MesaDTO(mesa.getId(), mesa.getPedido().getPratos(), mesa.getPedido().getTotalConsumido());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Prato> getListaPratos() {
        return listaPratos;
    }

    public void setListaPratos(List<Prato> listaPratos) {
        this.listaPratos = listaPratos;
    }

    public BigDecimal getTotalConsumido() {
        return totalConsumido;
    }

    public void setTotalConsumido(BigDecimal totalConsumido) {
        this.totalConsumido = totalConsumido;
    }
}
