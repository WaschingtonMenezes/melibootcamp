package com.example.aula3tt.service;

import com.example.aula3tt.repository.TurnStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TurnStatusService {
    TurnStatusRepository turnStatusRepository;

    @Autowired
    public TurnStatusService(TurnStatusRepository turnStatusRepository) {
        this.turnStatusRepository = turnStatusRepository;
    }
}
