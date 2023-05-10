package com.example.carnet.service;

import com.example.carnet.entity.Contact;
import com.example.carnet.entity.User;
import com.example.carnet.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Contact save(Contact contact) {

        return contactRepository.save(contact);
    }
    public Optional<Contact> fetchById(long id){
        return contactRepository.findById(id);
    }
    public Contact update(Contact contactToUpdate) {

        Optional<Contact> originalContact = contactRepository.findById(contactToUpdate.getId());

        if (originalContact.isPresent()) {
            Contact existingContact = originalContact.get();
            existingContact.setUsername(contactToUpdate.getUsername());
            existingContact.setEmail(contactToUpdate.getEmail());
            existingContact.setPhoneNumber(contactToUpdate.getPhoneNumber());
            return contactRepository.save(existingContact);
        }

        throw new IllegalArgumentException("This user is not found " + contactToUpdate.getId());
    }
}
