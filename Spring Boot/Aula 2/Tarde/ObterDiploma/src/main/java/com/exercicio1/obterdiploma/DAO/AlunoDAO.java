package com.exercicio1.obterdiploma.DAO;

import com.exercicio1.obterdiploma.DTO.AlunoDTO;
import com.exercicio1.obterdiploma.Entities.Aluno;
import com.exercicio1.obterdiploma.Entities.Diploma;

import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {
    private List<Aluno> alunos = new ArrayList<>();

    public AlunoDAO() {
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void adicionarAluno(Aluno aluno) {
        this.alunos.add(aluno);
    }

    public Diploma gerarDiploma(long id) {
        Aluno aluno = this.alunos.stream().filter(a -> a.getId() == id).findFirst().orElse(null);
        if (aluno != null) {
            Double average = aluno.getDisciplinas().stream().mapToDouble(c -> c.getNota()).sum() / aluno.getDisciplinas().size();
            return new Diploma(aluno, average >= 9 ? "Parabéns!": "", average);
        }
        return null;
    }

    public List<Aluno> obterAlunos(){
        return this.alunos;
    }

    public Aluno obterAlunoPorId(long id){
        return this.alunos.stream().filter(aluno -> aluno.getId() == id).findFirst().orElse(null);
    }
}
