package br.com.crud.crud.DTO;

import br.com.crud.crud.DAO.FuncionarioDAO;
import br.com.crud.crud.Entity.Funcionario;

public class FuncionarioDTO {
    private String nome;
    private String cpf;

    public FuncionarioDTO(String nome, String cpf) {
        super();
        this.nome = nome;
        this.cpf = cpf;
    }

    public FuncionarioDTO(Funcionario funcionario) {
        this.nome = funcionario.getNome();
        this.cpf = funcionario.getCpf();
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Funcionario converte(FuncionarioDTO funcionarioDTO, FuncionarioDAO funcionarioDAO) {
        return new Funcionario(funcionarioDAO.getFuncionarios().size() + 1, funcionarioDTO.nome, funcionarioDTO.cpf);
    }

    public static FuncionarioDTO converte(Funcionario funcionario) {
        return new FuncionarioDTO(funcionario.getNome(), funcionario.getCpf());
    }
}
