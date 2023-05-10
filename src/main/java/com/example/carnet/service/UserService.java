package com.example.carnet.service;

import com.example.carnet.entity.Contact;
import com.example.carnet.entity.User;
import com.example.carnet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public User save(User user) {
        return userRepository.save(user);
    }
    public User update(User userToUpdate) {

        Optional<User> originalUser = userRepository.findById(userToUpdate.getId());

        if (originalUser.isPresent()) {
            User existingUser = originalUser.get();
            existingUser.setName(userToUpdate.getName());
            existingUser.setUsername(userToUpdate.getUsername());
            existingUser.setEmail(userToUpdate.getEmail());
            existingUser.setImageUrl(userToUpdate.getImageUrl());
            return userRepository.save(existingUser);
        }

        throw new IllegalArgumentException("This user is not found " + userToUpdate.getId());
    }
}
