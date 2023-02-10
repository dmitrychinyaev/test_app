package ru.authorizationapp.controller;

import org.springframework.web.bind.annotation.*;
import ru.authorizationapp.model.User;
import ru.authorizationapp.service.UserService;

import java.util.List;

@RestController
//TODO
@RequestMapping("/api")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<User> all() {
        return service.all();
    }

    @GetMapping("/getId")
    public User getById(@RequestBody User user) {
        return service.getById(user);
    }

    @PostMapping
    public User save(@RequestBody User user) {
        return service.save(user);
    }

    @DeleteMapping
    public void removeById(@RequestBody User id) {
        service.removeById(id);
    }
}
