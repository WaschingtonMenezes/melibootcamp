package com.exercicio1.obterdiploma.DTO;

import com.exercicio1.obterdiploma.DAO.AlunoDAO;
import com.exercicio1.obterdiploma.Entities.Aluno;
import com.exercicio1.obterdiploma.Entities.Disciplina;

import java.util.ArrayList;
import java.util.List;

public class AlunoDTO {
    private String nome;
    private List<Disciplina> disciplinas;

    public AlunoDTO(String nome, List<Disciplina> disciplinas) {
        this.nome = nome;
        this.disciplinas = disciplinas;
    }

    public AlunoDTO(Aluno aluno) {
        this.nome = aluno.getNome();
        this.disciplinas = aluno.getDisciplinas();
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public static List<AlunoDTO> converte(List<Aluno> alunos) {
        List<AlunoDTO> alunosDTO = new ArrayList<>();
        alunos.forEach(a -> alunosDTO.add(new AlunoDTO(a)));
        return alunosDTO;
    }

    public static Aluno converte(AlunoDAO alunoDAO, AlunoDTO alunoDTO) {
        return new Aluno(alunoDAO.getAlunos().size()+1, alunoDTO.getNome(), alunoDTO.getDisciplinas());
    }
}
