package com.example.carnet.api;

import com.example.carnet.entity.Contact;
import com.example.carnet.service.ContactService;
import com.example.carnet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ContactRestController {
    @Autowired
    ContactService contactService;
    @GetMapping("/contacts")
    public ResponseEntity fetchAll() {

        return ResponseEntity.ok(contactService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Contact> getContactById(@PathVariable int id) {

        Optional<Contact> contact = contactService.fetchById(id);
        if (contact.isPresent()) {
            return ResponseEntity.ok(contact.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Contact> createContact(@RequestBody Contact contact) {

        Contact createdContact = contactService.save(contact);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdContact);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable int id, @RequestBody Contact contactToUpdate) {

        contactToUpdate.setId(id);
        try {
            Contact updatedContact = contactService.update(contactToUpdate);
            return ResponseEntity.ok(updatedContact);

        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable int id) {

        try {
            contactService.delete(id);
            return ResponseEntity.noContent().build();

        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
