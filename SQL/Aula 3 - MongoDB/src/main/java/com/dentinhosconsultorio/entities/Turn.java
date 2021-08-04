package com.dentinhosconsultorio.entities;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.time.LocalDate;

@Document(collection = "turns")
public class Turn {
    @Id
    private String id;
    private Patient patient;
    private Doctor doctor;
    private String date;
    private String status;

    public Turn(String id, Patient patient, Doctor doctor, String date, String status) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public String getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }
}
