package com.exercicio1.obterdiploma.Entities;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
    private long id;
    private String nome;
    private List<Disciplina> disciplinas = new ArrayList<>();

    public Aluno(long id, String nome, List<Disciplina> disciplinas) {
        this.id = id;
        this.nome = nome;
        this.disciplinas = disciplinas;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
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
}
