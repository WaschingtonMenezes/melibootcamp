package com.example.aula3tt.controllers;

import com.example.aula3tt.entities.Patient;
import com.example.aula3tt.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping
    public ResponseEntity<List<Patient>> getAllTurns() {
        return new ResponseEntity<>(this.patientService.findAllPatients(), HttpStatus.OK);
    }
}
