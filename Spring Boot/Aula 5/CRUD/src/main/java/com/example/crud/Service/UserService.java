package com.example.crud.Service;

import com.example.crud.Entities.User;
import com.example.crud.Exception.UserNotFoundException;
import com.example.crud.Repository.UserRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository repository) {
        this.userRepository = repository;
    }


    public User createUser (User user) {
        return this.userRepository.save(user);
    }

    public List<User> readUsers() {
        return this.userRepository.findAll();
    }

    public User updateUser (User user) {
        User oldUser = userRepository.findById(user.getId()).get();
        if(oldUser == null) {
            throw new UserNotFoundException("Usuário não encontrado");
        }
        oldUser.setName(user.getName());
        userRepository.save(oldUser);
        return oldUser;
    }

    public void deleteUser(long id) {
        User oldUser = userRepository.findById(id).get();
        if(oldUser == null) {
            throw new UserNotFoundException("Usuário não encontrado");
        }
        userRepository.delete(oldUser);
    }

    public User getUserById (long id) {
        return this.userRepository.getById(id);
    }

}
