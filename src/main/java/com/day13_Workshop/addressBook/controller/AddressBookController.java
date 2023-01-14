package com.day13_Workshop.addressBook.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.day13_Workshop.addressBook.models.Contact;
import com.day13_Workshop.addressBook.util.Contacts;


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
    public String saveContact() {

        return "displayContact";
    }
}
