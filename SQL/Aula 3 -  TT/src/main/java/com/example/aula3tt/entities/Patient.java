package com.example.aula3tt.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @NotBlank @NotEmpty private String name;
    @NotBlank @NotEmpty private String last_name;
    @NotBlank @NotEmpty private String address;
    @NotBlank @NotEmpty private String dni;
    @NotBlank @NotEmpty private String birth_date;
    @NotBlank @NotEmpty private String phone;
    @NotBlank @NotEmpty private String email;

    public Patient(long id, String name, String last_name, String address, String dni, String birth_date, String phone, String email) {
        this.id = id;
        this.name = name;
        this.last_name = last_name;
        this.address = address;
        this.dni = dni;
        this.birth_date = birth_date;
        this.phone = phone;
        this.email = email;
    }

    public Patient() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getAddress() {
        return address;
    }

    public String getDni() {
        return dni;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
}
