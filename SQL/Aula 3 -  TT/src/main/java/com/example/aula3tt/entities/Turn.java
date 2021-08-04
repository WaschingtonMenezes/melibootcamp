package com.example.aula3tt.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Turn {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @NotNull
    private LocalDate day;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_diary")
    private Diary diarys;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_turn_status")
    private TurnStatus turn_status;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_patient")
    private Patient patient;

    public Turn(long id, LocalDate day, Diary diarys, TurnStatus turn_status, Patient patient) {
        this.id = id;
        this.day = day;
        this.diarys = diarys;
        this.turn_status = turn_status;
        this.patient = patient;
    }

    public Turn() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }

    public Diary getDiarys() {
        return diarys;
    }

    public void setDiarys(Diary diarys) {
        this.diarys = diarys;
    }

    public TurnStatus getTurn_status() {
        return turn_status;
    }

    public void setTurn_status(TurnStatus turn_status) {
        this.turn_status = turn_status;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
