package com.aula3.starwars.Controller;

import com.aula3.starwars.Entities.Character;
import com.aula3.starwars.Repositories.CharacterRepository;
import com.aula3.starwars.Services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RestController
@RequestMapping("character")
public class CharacterController {
    private static CharacterService characterService;

    @Autowired
    public CharacterController(CharacterService service) {
        this.characterService = service;
    }

    @GetMapping
    @RequestMapping("/{word}")
    public ResponseEntity<List<String>> getListByString (@PathVariable String word) {
        try{
            List<String> listaCharacter = characterService.getListByString(word);
            if (listaCharacter.isEmpty()) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(listaCharacter, HttpStatus.OK);
        } catch (Exception err) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

}
