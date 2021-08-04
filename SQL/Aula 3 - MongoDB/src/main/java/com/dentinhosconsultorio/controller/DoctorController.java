package com.dentinhosconsultorio.controller;

import com.dentinhosconsultorio.entities.Doctor;
import com.dentinhosconsultorio.entities.Patient;
import com.dentinhosconsultorio.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    private DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctors () {
        return new ResponseEntity<>(this.doctorService.getAllDoctors(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Doctor> getAllDoctors (@RequestBody Doctor doctor) {
        return new ResponseEntity<>(this.doctorService.createDoctor(doctor), HttpStatus.OK);
    }
}
