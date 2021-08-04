package com.dentinhosconsultorio.controller;

import com.dentinhosconsultorio.entities.Patient;
import com.dentinhosconsultorio.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {
    private PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients () {
        return new ResponseEntity<>(this.patientService.getAllPatients(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Patient> getAllPatients (@RequestBody Patient patient) {
        return new ResponseEntity<>(this.patientService.createPatient(patient), HttpStatus.OK);
    }
}
