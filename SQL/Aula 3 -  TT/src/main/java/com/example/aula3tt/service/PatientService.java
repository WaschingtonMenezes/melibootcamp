package com.example.aula3tt.service;

import com.example.aula3tt.dtos.PatientByDayDTO;
import com.example.aula3tt.entities.Patient;
import com.example.aula3tt.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PatientService {
    PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> findAllPatients() {
        return this.patientRepository.findAll();
    }
}
