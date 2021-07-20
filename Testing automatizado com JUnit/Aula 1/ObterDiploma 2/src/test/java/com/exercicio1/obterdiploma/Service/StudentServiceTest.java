package com.exercicio1.obterdiploma.Service;

import com.exercicio1.obterdiploma.DTO.DiplomaDTO;
import com.exercicio1.obterdiploma.DTO.StudentDTO;
import com.exercicio1.obterdiploma.DTO.SubjectDTO;
import com.exercicio1.obterdiploma.Entities.Subject;
import com.exercicio1.obterdiploma.Services.StudentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Test
    @DisplayName("should return a Contratulations Degree DTO when analyze notes with high avarage.")
    public void testAnalyzeNotesHighAvarageCase() {
        StudentDTO student = new StudentDTO("any_name_string",
                List.of(
                        new SubjectDTO("any_subject", 10),
                        new SubjectDTO("any_subject", 10),
                        new SubjectDTO("any_subject", 10)
                ));

        DiplomaDTO diplomaDTO = studentService.analyzeNotes(student);

        DiplomaDTO expectedDegree = new DiplomaDTO(
                new StudentDTO(null, null),
                "Parabéns! Sua média foi de: 10,0",
                10.0);

        assertThat(diplomaDTO).usingRecursiveComparison().ignoringFields("student").isEqualTo(expectedDegree);
    }

    @Test
    @DisplayName("should return a DegreeDTO with avarage when analyze notes with low avarage.")
    public void testAnalyzeNotesLowAvarageCase() {
        StudentDTO student = new StudentDTO("any_name_string",
                List.of(
                        new SubjectDTO("any_subject", 1),
                        new SubjectDTO("any_subject", 1),
                        new SubjectDTO("any_subject", 1)
                ));

        DiplomaDTO diplomaDTO = studentService.analyzeNotes(student);

        DiplomaDTO expectedDegree = new DiplomaDTO(
                new StudentDTO(null, null),
                "Sua média foi de: 1,0",
                1.0);

        assertThat(diplomaDTO).usingRecursiveComparison().ignoringFields("student").isEqualTo(expectedDegree);
    }

    @Test
    @DisplayName("should return a reproved DegreeDTO if")
    public void testAnalyzeNotesWithoutNotesProvideAvarageCase() {
        StudentDTO student = new StudentDTO("any_name_string",
                List.of(
                        new SubjectDTO("any_subject", 1),
                        new SubjectDTO("any_subject", 1),
                        new SubjectDTO("any_subject", 1)
                ));

        DiplomaDTO diplomaDTO = studentService.analyzeNotes(student);

        DiplomaDTO expectedDegree = new DiplomaDTO(
                new StudentDTO(null, null),
                "Sua média foi de: 1,0",
                1.0);

        assertThat(diplomaDTO).usingRecursiveComparison().ignoringFields("student").isEqualTo(expectedDegree);
    }

    @Test
    @DisplayName("should return a right response when calculate avarage")
    public void testAvarage() {
        List<Subject> subjectList = List.of(
                new Subject("any_subject", 1.0),
                new Subject("any_subject", 1.0),
                new Subject("any_subject", 1.0)
        );
        double avarage = this.studentService.calculateAverage(subjectList);
        assertThat(avarage).isEqualTo(1d);
    }

    @Test
    @DisplayName("should return congratulation if avarage is bigger than 9")
    public void testWithHonorsCaseContratulations() {
        String message = this.studentService.withHonors(10d);
        assertThat("Parabéns! Sua média foi de: 10,0").isEqualTo(message);
    }

    @Test
    @DisplayName("should return congratulation if avarage is less than 9")
    public void testWithHonorsCaseNonCongratulations() {
        String message = this.studentService.withHonors(8d);
        assertThat("Sua média foi de: 8,0").isEqualTo(message);
    }
}
