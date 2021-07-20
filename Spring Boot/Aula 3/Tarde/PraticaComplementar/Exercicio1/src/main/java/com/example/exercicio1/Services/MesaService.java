package com.example.exercicio1.Services;

import com.example.exercicio1.Entity.Mesa;
import com.example.exercicio1.Repositories.MesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class MesaService {
    private MesaRepository mesaRepository;

    @Autowired
    public MesaService(MesaRepository repository) {
        this.mesaRepository = repository;
    }

    public Mesa getMesaById(long id){
        return this.mesaRepository.getMesaById(id);
    }

    public void add(Mesa mesa) {
        this.mesaRepository.add(mesa);
    }

    public BigDecimal closePayments(long idMesa) {
        return this.mesaRepository.closePayments(idMesa);
    }

}
