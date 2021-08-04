package com.example.aula3tt.controllers;

import com.example.aula3tt.entities.Dentist;
import com.example.aula3tt.service.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/dentist")
public class DentistController {
    @Autowired
    private final DentistService dentistService;

    public DentistController(DentistService dentistService) {
        this.dentistService = dentistService;
    }

    @GetMapping
    public ResponseEntity<List<Dentist>> getAllDentists() {
        return new ResponseEntity<>(this.dentistService.findAllDentists(), HttpStatus.OK);
    }

    @GetMapping(value = {"/{day}","/{day}/{turns}"})
    public ResponseEntity<List<Dentist>> getAllDentistsWithTurnsOnDay(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate day,
                                                                      @PathVariable(required = false) Long turns) {
        if (turns == null) turns = Long.valueOf(2);
        return new ResponseEntity<>(this.dentistService.findByNumbersOfTurnsOnDayGreaterThan(day, turns), HttpStatus.OK);
    }
}
