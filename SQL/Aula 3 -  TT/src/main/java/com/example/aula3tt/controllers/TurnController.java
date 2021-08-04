package com.example.aula3tt.controllers;

import com.example.aula3tt.dtos.PatientByDayDTO;
import com.example.aula3tt.dtos.TurnDentistDTO;
import com.example.aula3tt.entities.Dentist;
import com.example.aula3tt.entities.Patient;
import com.example.aula3tt.entities.Turn;
import com.example.aula3tt.service.TurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/turn")
public class TurnController {
    @Autowired
    private TurnService turnService;

    @GetMapping
    public ResponseEntity<List<Turn>> getAllTurns() {
        return new ResponseEntity<>(this.turnService.findAllTurns(), HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping("/turn-day/{day}")
    public ResponseEntity<List<PatientByDayDTO>> getPatientsByDay(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate day) {
        return new ResponseEntity<>(this.turnService.findPatientsByDay(day), HttpStatus.OK);
    }

    @GetMapping(value = {"/by-status/{status}", "/by-status"})
    public ResponseEntity<List<Turn>> getTurnByStatus(@PathVariable(required = false) String status) {
        if (status == null) status = "Concluido";
        return new ResponseEntity<>(this.turnService.findByStatus(status), HttpStatus.OK);
    }

    @GetMapping(value = {"/status-by-day/{day}", "status-by-day/{day}/{status}"})
    public ResponseEntity<List<Turn>> getTurnByDayAndStatus(@PathVariable(required = false) String status, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate day) {
        if (status == null) status = "Pendente";
        return new ResponseEntity<>(this.turnService.findByDayAndStatus(status, day), HttpStatus.OK);
    }

    @GetMapping("/turn-dentist/{idDentist}")
    public ResponseEntity<List<TurnDentistDTO>> getTurnByDentist(@PathVariable long idDentist) {
        return new ResponseEntity<>(this.turnService.findTurnByDentistId(idDentist), HttpStatus.OK);
    }
}
