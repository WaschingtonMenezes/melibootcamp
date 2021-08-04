package com.dentinhosconsultorio.services;

import com.dentinhosconsultorio.entities.Patient;
import com.dentinhosconsultorio.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    private PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient createPatient(Patient patient) {
       return  this.patientRepository.save(patient);
    }

    public List<Patient> getAllPatients() {
        return this.patientRepository.findAll();
    }
}
