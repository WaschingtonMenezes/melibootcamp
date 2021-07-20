package com.exercicio1.obterdiploma.DTO;

import com.exercicio1.obterdiploma.Entities.Student;
import com.exercicio1.obterdiploma.DTO.SubjectDTO;
import com.exercicio1.obterdiploma.Entities.Subject;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

public class StudentDTO {
    @NotNull(message = "O nome do Aluno deverá ser informado")
    @Size(min = 8, max = 50, message = "Nome do aluno mínimo 8 caracteres, máximo 50 caracteres")
    private String name;

    @NotNull
    @Valid
    @ManyToMany
    private List<SubjectDTO> subjects;

    public StudentDTO(String name, List<SubjectDTO> subjects) {
        this.name = name;
        this.subjects = subjects;
    }

    public StudentDTO(Student student) {
        this.name = student.getName();
        this.subjects = SubjectDTO.converte(student.getSubjects());
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SubjectDTO> getSubjects() {
        return subjects;
    }

    public void setDisciplinas(List<SubjectDTO> subjects) {
        this.subjects = subjects;
    }

    public static List<StudentDTO> converte(List<Student> students) {
        List<StudentDTO> studentsDTO = new ArrayList<>();
        students.forEach(a -> studentsDTO.add(new StudentDTO(a)));
        return studentsDTO;
    }

    public static StudentDTO converte(Student student) {
        return new StudentDTO(student.getName(), SubjectDTO.converte(student.getSubjects()));
    }
}
