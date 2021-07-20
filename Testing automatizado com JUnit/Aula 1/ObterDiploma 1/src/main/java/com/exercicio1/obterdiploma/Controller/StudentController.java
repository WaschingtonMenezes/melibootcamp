package com.exercicio1.obterdiploma.Controller;

import com.exercicio1.obterdiploma.DTO.DiplomaDTO;
import com.exercicio1.obterdiploma.DTO.StudentDTO;
import com.exercicio1.obterdiploma.Entities.Student;
import com.exercicio1.obterdiploma.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentDTO> obterStudents() {
        List<Student> Students = this.studentService.getStudents();
        return StudentDTO.converte(Students);
    }

    @PostMapping
    @RequestMapping("/analyzeNotes")
    public ResponseEntity<DiplomaDTO> analyzeNotes(@Valid @RequestBody StudentDTO studentDTO) {
        DiplomaDTO diploma = this.studentService.add(studentDTO);
        return new ResponseEntity<>(diploma, HttpStatus.CREATED);
    }
}
