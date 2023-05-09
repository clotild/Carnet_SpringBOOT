package com.example.carnet.api;


import com.example.carnet.entity.Contact;
import com.example.carnet.entity.User;
import com.example.carnet.service.ContactService;
import com.example.carnet.service.UserService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/secured")
public class ContactWebController {
    @Autowired
    UserService userService;
    ContactService contactService;

    @GetMapping("/contact")
    public String fetchAll(Model model) {
        model.addAttribute("user", userService.findById(1));
        return "contact";
    }

    @GetMapping("/create")
    public String createContact(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("contact", new Contact());

        return "createdContact";
    }

    @PostMapping("/createContacts")
    public String createContatSubmit(@ModelAttribute Model model, Contact contact, User user) {
        userService.save(user);
        contactService.save(contact);
        return "redirect:/secured/contact";
    }

    @GetMapping("/contact/delete")
    public String deleteContact(@PathParam("id_contact") int id_contact) {
        contactService.delete(id_contact);
        return "redirect:/secured/contact";
    }
}