package ru.authorizationapp.service;

import org.springframework.stereotype.Service;
import ru.authorizationapp.model.User;
import ru.authorizationapp.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> all() {
        return repository.all();
    }

    public User getById(User id) {
        return repository.getById(id);
    }

    public User save(User user) {
        return repository.save(user);
    }

    public void removeById(User id) {
        repository.removeById(id);
    }
}
