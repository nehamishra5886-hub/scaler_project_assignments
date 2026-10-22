package com.example.Evaluations.evaluation.repository;

import com.example.Evaluations.evaluation.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {

    private final Map<String, User> userMap;

    public UserRepository() {
        userMap = new HashMap<>();
    }

    public User save(User user) {
        userMap.put(user.getEmail(), user);
        return userMap.get(user.getEmail());
    }

    public boolean existsByEmail(String email) {
        return userMap.containsKey(email);
    }
    public User findByEmail(String email) {
        return userMap.get(email);
    }
}
