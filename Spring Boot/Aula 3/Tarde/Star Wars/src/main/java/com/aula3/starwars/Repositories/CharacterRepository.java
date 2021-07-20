package com.aula3.starwars.Repositories;

import com.aula3.starwars.Entities.Character;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CharacterRepository {
    private static final File FILE = new File("src/main/java/com/aula3/starwars/bd/starwars.json");

    @Autowired
    private ObjectMapper mapper;

    public List<String> getListByString(String word){
        List<Character> allCharacters = new ArrayList<>();
        List<String> characters = new ArrayList<>();
        try {
            FileInputStream is = new FileInputStream(FILE);
            TypeReference<List<Character>> typeReference = new TypeReference<List<Character>>() {};
            allCharacters = mapper.readValue(is, typeReference);
            allCharacters.forEach(c -> {
                if (c.getName().contains(word)) {
                    characters.add(c.getName());
                }
            });
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characters;
    }
}
