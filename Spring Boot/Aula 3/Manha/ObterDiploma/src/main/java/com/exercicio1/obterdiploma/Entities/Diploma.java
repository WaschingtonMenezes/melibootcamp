package com.exercicio1.obterdiploma.Entities;

public class Diploma {
    private Aluno aluno;
    private String mensagem;
    private Double media;

    public Diploma(Aluno aluno, String mensagem, Double media) {
        this.aluno = aluno;
        this.mensagem = mensagem;
        this.media = media;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Double getMedia() {
        return media;
    }

    public void setMedia(Double media) {
        this.media = media;
    }
}
