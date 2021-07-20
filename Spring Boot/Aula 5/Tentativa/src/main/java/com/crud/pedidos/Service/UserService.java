package com.crud.pedidos.Service;

import com.crud.pedidos.Entities.User;
import com.crud.pedidos.Repository.UserRepository;
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

    public User insertUser (User user) {
       return this.userRepository.save(user);
    }

    public User getUserById (long id) {
        return this.userRepository.getById(id);
    }

    public List<User> getUsers() {
        return this.userRepository.findAll();
    }
}
