package com.example.aula3tt.service;

import com.example.aula3tt.entities.Dentist;
import com.example.aula3tt.repository.DentistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DentistService {
    private DentistRepository dentistRepository;

    @Autowired
    public DentistService(DentistRepository dentistRepository) {
        this.dentistRepository = dentistRepository;
    }

    public List<Dentist> findAllDentists() {
        return this.dentistRepository.findAll();
    }

    public List<Dentist> findByNumbersOfTurnsOnDayGreaterThan(LocalDate day, Long turns) {
        return this.dentistRepository.findByNumbersOfTurnsOnDayGreaterThan(day, turns);
    }

}
