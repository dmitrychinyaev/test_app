package ru.authorizationapp.repository;

import org.springframework.stereotype.Repository;
import ru.authorizationapp.model.Quote;
import ru.authorizationapp.model.User;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@Repository
public class UserRepository {

    private final Map <Integer, User> userStorage = new ConcurrentHashMap<>();
    private final List<Quote> quotesStorage = new CopyOnWriteArrayList<>();

    public UserRepository(){};

    public User save(User user) {
        userStorage.put(getKey(user.getName(), user.getPassword()), user);
        return user;
    }

    public List <User> all() {
        return new ArrayList<>(userStorage.values());
    }

    private int getKey(String user, String password) {
        return Objects.hash(user, password);
    }

    public void removeById(User id){
        userStorage.remove(getKey(id.getName(), id.getPassword()));
    }

    public List <Quote> allQuotes() {
        return new ArrayList<>(quotesStorage);
    }

    public Quote saveQuote(User user, String text){
        Quote quote = user.makeQuote(text);
        quotesStorage.add(quote);
        return quote;
    }

    public Quote randomQuote(){
        Random random = new Random();
        int index = random.nextInt(quotesStorage.size());
        return quotesStorage.get(index);
    }

    public void upvoteQuote(int id){
       quotesStorage.get(id).upvote();
    }

    public void downvoteQuote(int id){
        quotesStorage.get(id).downvote();
    }


    public List<Quote> top10(){
        Comparator<Quote> compareByRating = Comparator.comparingInt(o -> o.getRating().get());
        Collections.sort(quotesStorage, compareByRating);
        return quotesStorage.subList(0,9);
    }

}
