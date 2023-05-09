package com.example.carnet.service;

import com.example.carnet.entity.Contact;
import com.example.carnet.entity.User;
import com.example.carnet.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {
    @Autowired
    ContactRepository contactRepository;

    public List<Contact> findAll() {
        return contactRepository.findAll();
    }
    public void delete(long id) {
        contactRepository.deleteById(id);
    }
    public void save(Contact contact) {
        contactRepository.save(contact);
    }
}
