package com.dentinhosconsultorio.services;

import com.dentinhosconsultorio.entities.Patient;
import com.dentinhosconsultorio.entities.Turn;
import com.dentinhosconsultorio.repositories.TurnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnService {
    private TurnRepository turnRepository;

    @Autowired
    public TurnService(TurnRepository turnRepository) {
        this.turnRepository = turnRepository;
    }

    public Turn createTurn(Turn turn) {
        return  this.turnRepository.save(turn);
    }

    public List<Turn> getAllTurns() {
        return this.turnRepository.findAll();
    }
}
