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

    public DiplomaDTO analyzeNotes (StudentDTO student) {
        if (student.getSubjects().isEmpty() || student.getSubjects() == null) {
            return new DiplomaDTO(student, "Reprovado", 0.0);
        }
        List<Subject> subjectList = this.subjectService.addSubjectLists(student.getSubjects());
        Student studentCreated = this.studentRepository.save(new Student(student.getName(), subjectList));

        double average = calculateAverage(subjectList);

        return new DiplomaDTO(StudentDTO.converte(studentCreated), withHonors(average), average);
    }

    public double calculateAverage(List<Subject> subjectList) {
        return subjectList.stream().mapToDouble(c -> c.getNote()).sum() / subjectList.size();
    }

    public String withHonors(Double average) {
        String message = "Sua média foi de:" + String.format(" %.1f", average);
        return average >= 9 ? "Parabéns! " + message : message;
    }
}
