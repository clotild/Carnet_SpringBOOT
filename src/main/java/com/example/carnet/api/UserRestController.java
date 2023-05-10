package com.example.carnet.api;

import com.example.carnet.entity.User;
import com.example.carnet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserRestController {
    @Autowired
    UserService userService;

    @GetMapping("/users")
    public ResponseEntity findAll() {
        return ResponseEntity.ok(userService.findAll());
    }
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {

        User createdUser = userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody User userToUpdate) {

        userToUpdate.setId(id);
        try {
            User updatedUser = userService.update(userToUpdate);
            return ResponseEntity.ok(updatedUser);

        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
