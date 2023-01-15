package com.day13_Workshop.addressBook.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.day13_Workshop.addressBook.models.Contact;
import com.day13_Workshop.addressBook.util.Contacts;

import jakarta.validation.Valid;


@Controller
@RequestMapping
public class AddressBookController {
    
    // importing helper class Contacts.java for contact operations
    @Autowired
    Contacts contactsHelper;

    @Autowired
    ApplicationArguments appArgs;


    // contact 
    @GetMapping(path="/addressbook")
    public String getForm(Model model) {
        Contact newContact = new Contact();
        newContact.setBirthDate(LocalDate.of(1992, 01, 28));
        System.out.println("newContact ID: " + newContact.getId());
        System.out.println("birthDate: " + newContact.getBirthDate());
        System.out.println("calculated Age: " + newContact.getAge());
        System.out.println("appArgs: " + appArgs.getOptionValues("dataDir"));
        model.addAttribute("contact", newContact);
        return "addressbook";
    }


    // method to receive contact for validation and 
    @PostMapping(path="/contact")
    // @Valid Contact contact, 
    public String saveContact(Model model, @Valid Contact contact) {

        String path = appArgs.getOptionValues("dataDir").get(0);

        model.addAttribute("validContact", contact);

        // System.out.println("Valid contact received: " + contact);
        // System.out.println("Application Arguments: " + path);

        // call helper class to save contact details
        contactsHelper.saveContact(contact, path);

        // send created HTTP code HOW TO DO??
        System.out.println();
        return "displayContact";
    }


    // GET /contact/{id} request handler
    @GetMapping(path="/contact/{id}")
    public String getContact(Model model, @PathVariable String id) {
        System.out.println("Received ID: " + id);
        // call method to retrieve contact object (with data)
        Contact contact = contactsHelper.getContact();

        // add contact object to model

        // change this to displayContacts (after testing)
        return "contactLinks";
    }
}
