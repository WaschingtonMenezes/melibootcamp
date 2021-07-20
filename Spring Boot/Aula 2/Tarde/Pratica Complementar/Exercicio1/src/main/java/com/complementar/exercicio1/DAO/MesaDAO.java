package com.complementar.exercicio1.DAO;

import com.complementar.exercicio1.Entity.Mesa;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MesaDAO {
    private BigDecimal valorCaixa = new BigDecimal(0);
    private List<Mesa> listaMesas = new ArrayList<>();

    public BigDecimal fecharCaixa() {
        valorCaixa = valorCaixa.add(this.listaMesas.stream().map(m -> m.getPedido().getTotalConsumido()).reduce((x, y) -> x.add(y)).get());
        this.listaMesas = new ArrayList<>();
        return this.valorCaixa;
    }

    public void adicionarMesa(Mesa mesa) {
        this.listaMesas.add(mesa);
    }

    public List<Mesa> listarMesas() {
        return this.listaMesas;
    }

    public Mesa obterMesaPorId(long id){
        return this.listaMesas.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    public BigDecimal getValorCaixa() {
        return valorCaixa;
    }

    public List<Mesa> getListaMesas() {
        return listaMesas;
    }

    public void setValorCaixa(BigDecimal valorCaixa) {
        this.valorCaixa = valorCaixa;
    }

    public void setListaMesas(List<Mesa> listaMesas) {
        this.listaMesas = listaMesas;
    }
}
