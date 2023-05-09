package com.example.carnet.service;

import com.example.carnet.entity.User;
import com.example.carnet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }
    public User findById(long id) {
        return userRepository.findById(id).get();
    }
    public void save(User user) {
        userRepository.save(user);
    }
}
