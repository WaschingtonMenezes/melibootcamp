package com.aula3.starwars.Services;

import com.aula3.starwars.Entities.Character;
import com.aula3.starwars.Repositories.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {
    private CharacterRepository repository;

    @Autowired
    public CharacterService(CharacterRepository repository) {
        this.repository = repository;
    }

    public List<String> getListByString(String word) {
        return repository.getListByString(word);
    }
}
