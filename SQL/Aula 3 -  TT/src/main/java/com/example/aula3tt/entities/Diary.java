package com.example.aula3tt.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Time;

@Entity
public class Diary {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @NotNull @NotBlank private Time start_time;
    @NotNull @NotBlank private Time ending_time;

    @ManyToOne
    @JoinColumn(name = "id_dentist")
    private Dentist dentist;

    public Diary() {
    }

    public Diary(long id, Time start_time, Time ending_time, Dentist dentist) {
        this.id = id;
        this.start_time = start_time;
        this.ending_time = ending_time;
        this.dentist = dentist;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Dentist getDentist() {
        return dentist;
    }

    public void setDentist(Dentist dentist) {
        this.dentist = dentist;
    }
}
