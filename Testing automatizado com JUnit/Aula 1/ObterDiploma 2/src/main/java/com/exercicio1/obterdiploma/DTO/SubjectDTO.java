package com.exercicio1.obterdiploma.DTO;

import com.exercicio1.obterdiploma.Entities.Subject;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

public class SubjectDTO {
    @NotNull(message = "O nome da matéria deverá ser informada")
    @Size(min = 8, max = 50, message = "Nome da matéria mínimo 8 caracteres, máximo 50 caracteres")
    private String subject;

    @NotNull(message = "A nota deverá ser informada")
    private double note;

    public SubjectDTO(String subject, double note) {
        this.subject = subject;
        this.note = note;
    }

    public String getSubject() {
        return subject;
    }

    public double getNote() {
        return note;
    }
    
    public static SubjectDTO converte(Subject subject) {
        return new SubjectDTO(subject.getSubject(), subject.getNote());
    }

    public static List<SubjectDTO> converte(List<Subject> subjects) {
        List<SubjectDTO> listSubjects = new ArrayList<>();
        subjects.forEach(subject -> listSubjects.add(new SubjectDTO(subject.getSubject(), subject.getNote())));
        
        return listSubjects;
    }
}
