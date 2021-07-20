package com.example.crud.Controller;

import com.example.crud.Entities.User;
import com.example.crud.Service.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @ResponseBody
    public List<User> getUsers() {
        return this.userService.readUsers();
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<User> createUser(@RequestBody User user, UriComponentsBuilder uriBuilder) {
        try {
            this.userService.createUser(user);
            URI uri = uriBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri();
            return ResponseEntity.created(uri).build();
        } catch (Exception err) {
            System.out.println(err);
            return null;
        }
    }

    @PutMapping
    @ResponseBody
    public ResponseEntity<User> updateUser(@RequestBody User user, UriComponentsBuilder uriBuilder) {
        try {
            this.userService.updateUser(user);
            URI uri = uriBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri();
            return ResponseEntity.created(uri).build();
        } catch (Exception err) {
            System.out.println(err);
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void updateUser(@PathVariable long id) {
        try {
            this.userService.deleteUser(id);
        } catch (Exception err) {
            System.out.println(err);
        }
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable long id) {
        User user = this.userService.getUserById(id);
        return user;
    }
}
