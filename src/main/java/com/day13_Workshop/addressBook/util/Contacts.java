package com.day13_Workshop.addressBook.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import com.day13_Workshop.addressBook.models.Contact;

// helper class for saving and retrieving contact information
@Component
public class Contacts {
    // require model, path
    public void saveContact(Contact contact, String path) { 
        System.out.println("Inside Contacts"); // REMOVE

        // file name (object id)
        String fileName = contact.getId();
        
        // // create folder path
        File dirPath = new File(path);

        // create path for file
        File filePath = new File(dirPath, fileName);
        
        // write content to file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) { // FileWriter creates the file
            // extract information from contact
            writer.write(contact.getName() + "\n");
            writer.write(contact.getEmail() + "\n");
            writer.write(contact.getPhone() + "\n");
            writer.write(contact.getBirthDate() + "\n");

        } catch(IOException e) {
            e.getMessage();
        }

    }
}
