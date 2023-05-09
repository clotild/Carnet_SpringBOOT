package com.example.carnet.api;

import com.example.carnet.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {
    @Autowired
    ContactService contactService;
    @GetMapping("/contacts")
    public ResponseEntity fetchAll() {
        return ResponseEntity.ok(contactService.findAll());
    }
}
