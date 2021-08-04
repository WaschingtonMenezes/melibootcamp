package com.example.aula3tt.dtos;

import com.example.aula3tt.entities.Patient;
import java.sql.Time;
import java.time.LocalDate;

public class TurnDentistDTO {
    private String dentist_name;
    private Patient patient;
    private Time start_time;
    private Time ending_time;
    private LocalDate day;

    public TurnDentistDTO(String dentist_name, Patient patient, Time start_time, Time ending_time, LocalDate day) {
        this.dentist_name = dentist_name;
        this.patient = patient;
        this.start_time = start_time;
        this.ending_time = ending_time;
        this.day = day;
    }

    public TurnDentistDTO() {
    }

    public String getDentist_name() {
        return dentist_name;
    }

    public void setDentist_name(String dentist_name) {
        this.dentist_name = dentist_name;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Time getStart_time() {
        return start_time;
    }

    public void setStart_time(Time start_time) {
        this.start_time = start_time;
    }

    public Time getEnding_time() {
        return ending_time;
    }

    public void setEnding_time(Time ending_time) {
        this.ending_time = ending_time;
    }

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }
}
