package com.example.exercicio1.Controllers;

import com.example.exercicio1.DTO.MesaDTO;
import com.example.exercicio1.Entity.Mesa;
import com.example.exercicio1.Services.MesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/restaurante")
public class MesaController {
    @Autowired
    private MesaService mesaService;

    @GetMapping
    @RequestMapping({"/{id}"})
    public ResponseEntity<MesaDTO> obterItensMesa(@PathVariable long id) {
        try{
            Mesa mesa = this.mesaService.getMesaById(id);
            if (mesa == null) return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            return new ResponseEntity<>(MesaDTO.obterItens(mesa), HttpStatus.OK);
        } catch (Exception err){
            return new ResponseEntity(err.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    @RequestMapping({"/fecharCaixa/{idMesa}"})
    public ResponseEntity<BigDecimal> closePayment(@PathVariable long idMesa) {
        try{
            BigDecimal caixa = this.mesaService.closePayments(idMesa);
            return new ResponseEntity<>(caixa, HttpStatus.OK);
        } catch (Exception err){
            return new ResponseEntity(err.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<MesaDTO> addMesa(@RequestBody Mesa mesa) {
        try {
            this.mesaService.add(mesa);
            return new ResponseEntity<>(null, HttpStatus.CREATED);
        } catch (Exception err){
            return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
        }
    }
}
