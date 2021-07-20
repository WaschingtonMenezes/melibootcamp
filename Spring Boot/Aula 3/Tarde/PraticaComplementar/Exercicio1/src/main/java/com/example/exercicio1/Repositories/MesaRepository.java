package com.example.exercicio1.Repositories;

import com.example.exercicio1.Entity.Mesa;
import com.example.exercicio1.Entity.Pedido;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MesaRepository {
    private static final File FILE = new File("src/main/java/com/example/exercicio1/bd/bd.json");
    @Autowired
    private ObjectMapper mapper;


    public List<Mesa> getList(){
        List<Mesa> listaMesas = new ArrayList<>();
        try {
            FileInputStream is = new FileInputStream(FILE);
            TypeReference<List<Mesa>> typeReference = new TypeReference<List<Mesa>>() {};
            listaMesas = mapper.readValue(is, typeReference);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listaMesas;
    }

    public Mesa getMesaById(long id){
        List<Mesa> listaMesas = getList();
        return listaMesas.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    public void add(Mesa mesa) {
        List<Mesa> mesas = getList();
        mesas.add(mesa);
        reWriteJSON(mesas);
    }

    public BigDecimal closePayments(long idMesa) {
        List<Mesa> listaMesas = getList();
        Mesa mesa = listaMesas.stream().filter(m -> m.getId() == idMesa).findFirst().orElse(null);

        List<Pedido> listaPedidos = mesa.getPedidos();
        BigDecimal valorCaixa = new BigDecimal(0);

        valorCaixa = valorCaixa.add(listaPedidos.stream().map(m -> m.getTotalConsumido()).reduce((x, y) -> x.add(y)).get());

        listaMesas.get(listaMesas.indexOf(mesa)).setPedidos(null);
        reWriteJSON(listaMesas);
        return valorCaixa;
    }

    private void reWriteJSON(List<Mesa> listaMesa) {
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE)));
            mapper.writeValue(out, listaMesa);
            out.close();
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
