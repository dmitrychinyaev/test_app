package ru.authorizationapp.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.authorizationapp.model.User;
import ru.authorizationapp.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<User> all() {
        return service.all();
    }

    @PostMapping
    public User save(@RequestBody @Validated User user) {
        return service.save(user);
    }

    @DeleteMapping
    public void removeById(@RequestBody @Validated User id) {
        service.removeById(id);
    }
}
