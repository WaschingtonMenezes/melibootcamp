package com.example.exercicio2;

import com.example.exercicio2.DAO.ClienteDAO;
import com.example.exercicio2.DTO.ClienteDTO;
import com.example.exercicio2.Entities.Cliente;
import com.example.exercicio2.Entities.Produto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("clientes")
public class Exercicio2Application {
    private static ClienteDAO clienteDAO = new ClienteDAO();

    public static void main(String[] args) {
        SpringApplication.run(Exercicio2Application.class, args);
    }

    @PostMapping
    public static ResponseEntity<Cliente> adicionarCliente(@RequestBody ClienteDTO clienteInsercao) {
        try {
            Cliente cliente = ClienteDTO.converte(clienteInsercao, clienteDAO);
            clienteDAO.adicionar(cliente);
            return new ResponseEntity<>(cliente, HttpStatus.CREATED);
        } catch (Exception err) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    @RequestMapping("{id}")
    public static ResponseEntity<ClienteDTO> buscarClientePorId(@PathVariable long id) {
        try {
            Cliente cliente = clienteDAO.retonaFuncionarioPorId(id);
            if (cliente != null){
                ClienteDTO dto = ClienteDTO.converte(cliente);
                return new ResponseEntity<>(dto, HttpStatus.OK);
            }
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        } catch (Exception err) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
