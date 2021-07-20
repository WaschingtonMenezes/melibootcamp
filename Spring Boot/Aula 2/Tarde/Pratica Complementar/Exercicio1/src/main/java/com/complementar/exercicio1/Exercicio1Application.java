package com.complementar.exercicio1;

import com.complementar.exercicio1.DAO.MesaDAO;
import com.complementar.exercicio1.DTO.MesaDTO;
import com.complementar.exercicio1.Entity.Mesa;
import com.complementar.exercicio1.Entity.Restaurante;
import org.apache.coyote.Response;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@SpringBootApplication
@RestController
@RequestMapping("/restaurante")
public class Exercicio1Application {
    private static MesaDAO mesaDAO = new MesaDAO();

    public static void main(String[] args) {
        SpringApplication.run(Exercicio1Application.class, args);
    }

    @GetMapping
    @RequestMapping({"/{id}"})
    public ResponseEntity<MesaDTO> obterItensMesa(@PathVariable long id) {
        try{
            Mesa mesa = this.mesaDAO.obterMesaPorId(id);
            if (mesa == null) return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            return new ResponseEntity<>(MesaDTO.obterItens(mesa), HttpStatus.OK);
        } catch (Exception err){
            return new ResponseEntity(err.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    @RequestMapping({"/fecharCaixa"})
    public ResponseEntity<BigDecimal> fecharCaixa() {
        try{
            BigDecimal caixa = this.mesaDAO.fecharCaixa();
            return new ResponseEntity<>(caixa, HttpStatus.OK);
        } catch (Exception err){
            return new ResponseEntity(err.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<MesaDTO> cadastrarMesa(@RequestBody Mesa mesa) {
        try {
            this.mesaDAO.adicionarMesa(mesa);
            return new ResponseEntity<>(null, HttpStatus.CREATED);
        } catch (Exception err){
            return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
        }
    }
}
