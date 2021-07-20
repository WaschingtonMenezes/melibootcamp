package com.exercicio1.obterdiploma.Services;

import com.exercicio1.obterdiploma.DTO.StudentDTO;
import com.exercicio1.obterdiploma.DTO.DiplomaDTO;
import com.exercicio1.obterdiploma.Entities.Student;
import com.exercicio1.obterdiploma.Entities.Subject;
import com.exercicio1.obterdiploma.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {
    private StudentRepository studentRepository;
    private SubjectService subjectService;

    @Autowired
    public StudentService(StudentRepository studentRepository, SubjectService subjectService) {
        this.studentRepository = studentRepository;
        this.subjectService = subjectService;
    }

    public List<Student> getStudents(){
        return this.studentRepository.findAll();
    }

    public DiplomaDTO add (StudentDTO student) {
        List<Subject> subjectList = this.subjectService.addSubjectLists(student.getSubjects());
        Student studentCreated = this.studentRepository.save(new Student(student.getName(), subjectList));
        double average = student.getSubjects().stream().mapToDouble(c -> c.getNote()).sum() / student.getSubjects().size();

        String message = "Sua média foi de:" + String.format(" %.1f", average);

        return new DiplomaDTO(StudentDTO.converte(studentCreated), average >= 9 ? "Parabéns! " + message : message, average);
    }
}
