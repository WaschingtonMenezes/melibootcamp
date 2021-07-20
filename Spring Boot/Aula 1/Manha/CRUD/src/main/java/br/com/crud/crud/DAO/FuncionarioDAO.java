package br.com.crud.crud.DAO;

import br.com.crud.crud.Entity.Funcionario;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class FuncionarioDAO {
    private List<Funcionario> listaFuncionarios = new ArrayList<>();

    public FuncionarioDAO() {
    }

    public List<Funcionario> getFuncionarios() {
        return listaFuncionarios;
    }

    public void adicionar(Funcionario funcionario) {
        this.listaFuncionarios.add(funcionario);
    }

    public void alterar(Funcionario funcionarioAlteracao) {
        Optional<Funcionario> funcionario = listaFuncionarios.stream().filter(a -> a.getCpf().equals(funcionarioAlteracao.getCpf())).findFirst();
        if(funcionario.isPresent()) {
            this.listaFuncionarios.forEach(f -> {
                if (f.getCpf().equals(funcionarioAlteracao.getCpf())){
                    f.setNome(funcionarioAlteracao.getNome());
                }
            });
        }

    }

    public void remover(String cpf) {
        Optional<Funcionario> funcionario = listaFuncionarios.stream().filter(a -> a.getCpf().equals(cpf)).findFirst();
        if(funcionario.isPresent()) {
            this.listaFuncionarios.remove(funcionario.get());
        }
    }

    public Optional<Funcionario> obterFuncionarioPorId(long id) {
        return listaFuncionarios.stream().filter(a -> a.getId() == id).findFirst();
    }
}
