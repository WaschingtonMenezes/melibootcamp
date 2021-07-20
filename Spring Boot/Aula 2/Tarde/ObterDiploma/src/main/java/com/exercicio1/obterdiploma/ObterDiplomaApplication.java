package com.exercicio1.obterdiploma;

import com.exercicio1.obterdiploma.DAO.AlunoDAO;
import com.exercicio1.obterdiploma.DTO.AlunoDTO;
import com.exercicio1.obterdiploma.Entities.Aluno;
import com.exercicio1.obterdiploma.Entities.Diploma;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
public class ObterDiplomaApplication {
    private AlunoDAO alunoDAO = new AlunoDAO();

    public static void main(String[] args) {
        SpringApplication.run(ObterDiplomaApplication.class, args);
    }

    @GetMapping
    public List<AlunoDTO> obterAlunos() {
        List<Aluno> alunos = alunoDAO.obterAlunos();
        return AlunoDTO.converte(alunos);
    }

    @GetMapping
    @RequestMapping("/diploma/{id}")
    public ResponseEntity<Diploma> obterDiplomaAluno(@PathVariable long id) {
        return new ResponseEntity<>(this.alunoDAO.gerarDiploma(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AlunoDTO> inserirAluno(@RequestBody AlunoDTO alunoDTO) {
        Aluno aluno = AlunoDTO.converte(alunoDAO, alunoDTO);
        alunoDAO.adicionarAluno(aluno);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }
}
