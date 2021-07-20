package br.com.crud.crud.Controllers;

import br.com.crud.crud.DAO.FuncionarioDAO;
import br.com.crud.crud.DTO.FuncionarioDTO;
import br.com.crud.crud.Entity.Funcionario;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/funcionarios")
public class FuncionarioController {
    private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

    @PostMapping
    public ResponseEntity<FuncionarioDTO> adicionarFuncionario(@RequestBody FuncionarioDTO funcionarioDTO, UriComponentsBuilder uriBuilder){
        Funcionario funcionario = funcionarioDTO.converte(funcionarioDTO, funcionarioDAO);
        try {
            this.funcionarioDAO.adicionar(funcionario);
            URI uri = uriBuilder.path("/funcionarios/{id}").buildAndExpand(funcionario.getId()).toUri();
            return ResponseEntity.created(uri).build();
        } catch (Exception err) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<FuncionarioDTO> alterarFuncionario(@RequestBody FuncionarioDTO funcionarioDTO) {
        Funcionario funcionario = new Funcionario(0, funcionarioDTO.getNome(), funcionarioDTO.getCpf());
        try {
            this.funcionarioDAO.alterar(funcionario);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception err) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<FuncionarioDTO> removerFuncionario(@PathVariable String cpf) {
        try {
            funcionarioDAO.remover(cpf);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<FuncionarioDTO>> obterFuncionarios() {
        try {
            List<FuncionarioDTO> funcionarios = new ArrayList<FuncionarioDTO>();
            this.funcionarioDAO.getFuncionarios().forEach(funcionario -> funcionarios.add(new FuncionarioDTO(funcionario)));
            if (funcionarios.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(funcionarios, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    @RequestMapping("/{id}")
    public ResponseEntity<FuncionarioDTO> obterFuncionarioPorId(@PathVariable long id) {
        try {
            Optional<Funcionario> funcionario = this.funcionarioDAO.obterFuncionarioPorId(id);
            if (funcionario.isPresent()) {
                FuncionarioDTO funcionarioDTO = new FuncionarioDTO(funcionario.get());
                return  new ResponseEntity<>(funcionarioDTO, HttpStatus.OK);
            }
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}