package com.crud.pedidos.Controller;

import com.crud.pedidos.DTO.ProductInsertionDTO;
import com.crud.pedidos.Entities.Product;
import com.crud.pedidos.Entities.User;
import com.crud.pedidos.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @ResponseBody
    public List<User> getUsers() {
        return this.userService.getUsers();
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<User> insertProduct (@RequestBody User user, UriComponentsBuilder uriBuilder) {
        try {
            this.userService.insertUser(user);
            URI uri = uriBuilder.path("/anuncios/{id}").buildAndExpand(user.getId()).toUri();
            return ResponseEntity.created(uri).build();
        } catch (Exception err) {
            System.out.println(err);
            return null;
        }
    }

    @GetMapping
    @ResponseBody
    @RequestMapping("/{id}")
    public User getUser(@PathVariable long id) {
        User user = this.userService.getUserById(id);
        return user;
    }
}
