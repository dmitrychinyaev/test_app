package ru.authorizationapp.repository;

import org.springframework.stereotype.Repository;
import ru.authorizationapp.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {

    private final Map <Integer, User> storage = new ConcurrentHashMap<>();

    public User save(User user) {
        storage.put(getKey(user.getName(), user.getPassword()), user);
        return user;
    }

    public List <User> all() {
        return new ArrayList<>(storage.values());
    }

    public User getById (User user){
        return storage.get(getKey(user.getName(), user.getPassword()));
    }

    private int getKey(String user, String password) {
        return Objects.hash(user, password);
    }

    public void removeById(User id){
        storage.remove(getKey(id.getName(), id.getPassword()));
    }

}
