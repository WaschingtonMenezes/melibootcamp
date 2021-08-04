package com.dentinhosconsultorio.entities;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document(collection = "doctors")
public class Doctor {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String speciality;

    public Doctor(String id, String firstName, String lastName, String speciality) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.speciality = speciality;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSpeciality() {
        return speciality;
    }
}
