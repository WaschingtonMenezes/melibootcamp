package com.dentinhosconsultorio.controller;

import com.dentinhosconsultorio.entities.Patient;
import com.dentinhosconsultorio.entities.Turn;
import com.dentinhosconsultorio.services.TurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turns")
public class TurnsController {
    private TurnService turnService;

    @Autowired
    public TurnsController(TurnService turnService) {
        this.turnService = turnService;
    }

    @GetMapping
    public ResponseEntity<List<Turn>> getAllPatients () {
        return new ResponseEntity<>(this.turnService.getAllTurns(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Turn> getAllPatients (@RequestBody Turn turn) {
        return new ResponseEntity<>(this.turnService.createTurn(turn), HttpStatus.OK);
    }
}
