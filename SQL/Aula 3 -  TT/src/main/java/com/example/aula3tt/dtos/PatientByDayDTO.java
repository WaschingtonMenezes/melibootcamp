package com.example.aula3tt.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.time.LocalDate;

public class PatientByDayDTO {
    private String patient_name;
    private LocalDate day;
    private String dentist_name;
    private String turn_status;
    private Time start_time;
    private Time ending_time;

    public PatientByDayDTO(String patient_name, LocalDate day, String dentist_name, String turn_status, Time start_time, Time ending_time) {
        this.patient_name = patient_name;
        this.day = day;
        this.dentist_name = dentist_name;
        this.turn_status = turn_status;
        this.start_time = start_time;
        this.ending_time = ending_time;
    }

    public String getPatient_name() {
        return patient_name;
    }

    public LocalDate getDay() {
        return day;
    }

    public String getDentist_name() {
        return dentist_name;
    }

    public String getTurn_status() {
        return turn_status;
    }

    public Time getStart_time() {
        return start_time;
    }

    public Time getEnding_time() {
        return ending_time;
    }
}
