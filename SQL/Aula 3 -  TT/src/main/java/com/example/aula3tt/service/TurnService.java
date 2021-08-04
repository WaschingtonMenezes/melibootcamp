package com.example.aula3tt.service;

import com.example.aula3tt.dtos.PatientByDayDTO;
import com.example.aula3tt.dtos.TurnDentistDTO;
import com.example.aula3tt.dtos.mappers.PatientMapper;
import com.example.aula3tt.dtos.mappers.TurnMapper;
import com.example.aula3tt.entities.Dentist;
import com.example.aula3tt.entities.Patient;
import com.example.aula3tt.entities.Turn;
import com.example.aula3tt.repository.TurnRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TurnService {
    private TurnRepository turnRepository;

    public TurnService(TurnRepository turnRepository) {
        this.turnRepository = turnRepository;
    }

    public List<Turn> findAllTurns() {
        return this.turnRepository.findAll();
    }

    public List<PatientByDayDTO> findPatientsByDay(LocalDate day) {
        List<Turn> listTurn = this.turnRepository.findByDay(day);
        return PatientMapper.convert(listTurn);
    }

    public List<Turn> findByStatus (String status){
        return this.turnRepository.findByTurnStatusName(status);
    }

    public List<Turn> findByDayAndStatus (String status, LocalDate day){
        return this.turnRepository.findByDayAndStatus(status, day);
    }

    public List<TurnDentistDTO> findTurnByDentistId(Long id) {
        return TurnMapper.convert(this.turnRepository.findByDiarysDentistId(id));
    }
}
