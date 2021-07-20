package com.exercicio1.obterdiploma.DTO;

import com.exercicio1.obterdiploma.Entities.Student;

public class DiplomaDTO {
    private StudentDTO student;
    private String message;
    private Double avarege;

    public DiplomaDTO(StudentDTO Student, String message, Double avarege) {
        this.student = Student;
        this.message = message;
        this.avarege = avarege;
    }

    public StudentDTO getStudent() {
        return student;
    }

    public void setStudent(StudentDTO Student) {
        this.student = Student;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Double getAvarege() {
        return avarege;
    }

    public void setAvarege(Double avarege) {
        this.avarege = avarege;
    }
}
