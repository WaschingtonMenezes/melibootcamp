package com.exercicio1.obterdiploma.Controller;

import com.exercicio1.obterdiploma.DTO.StudentDTO;
import com.exercicio1.obterdiploma.DTO.SubjectDTO;
import com.exercicio1.obterdiploma.Repository.StudentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class StudentControllerTest {
    @Autowired
    private MockMvc mock;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ObjectMapper mapper = new ObjectMapper();

    @BeforeEach
    private void init() {
        studentRepository.deleteAll();
    }

    @Test
    public void ShouldThrowsIfAnInvalidParamAreProvided() throws Exception {
        List<SubjectDTO> subjectList = new ArrayList<>(){
            { add: new SubjectDTO("any_subject1", 10); }
            { add: new SubjectDTO("any_subject2", 10); }
        };
        StudentDTO studentDTO = new StudentDTO(null, subjectList);

        String payLoad = mapper.writeValueAsString(studentDTO);
        mock.perform(post("/analyzeNotes")
                .contentType("application/json")
                .content(payLoad))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void ShouldSuceedsIfAValidParamAreProvided() throws Exception {
        List<SubjectDTO> subjectList = new ArrayList<>(){
            { add: new SubjectDTO("any_subject1", 10); }
            { add: new SubjectDTO("any_subject2", 10); }
        };
        StudentDTO studentDTO = new StudentDTO("valid_name", subjectList);

        String payLoad = mapper.writeValueAsString(studentDTO);
        mock.perform(post("/analyzeNotes")
                .contentType("application/json")
                .content(payLoad))
                .andExpect(status().isCreated());
    }

    @Test
    public void ShouldReturnReprovedAreProvided() throws Exception {
        StudentDTO studentDTO = new StudentDTO("valid_name", new ArrayList<>());

        String payLoad = mapper.writeValueAsString(studentDTO);
        mock.perform(post("/analyzeNotes")
                .contentType("application/json")
                .content(payLoad))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.message", Is.is("Reprovado")));
    }
}
