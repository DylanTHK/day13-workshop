package com.day13_Workshop.addressBook.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.day13_Workshop.addressBook.models.Contact;


// helper class for saving and retrieving contact information
@Component
public class Contacts {
    // method to save contact as file
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

    // method to create and retrieve contact form file
    // parameters: file directory, desired id
    public void getContactById(Model model, String id, String dir) {
        // set random new contact
        Contact contact = new Contact();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            // setting path instance
            Path filePath = new File(dir + "/" + id).toPath();
            // setting charset (UTF-8)
            Charset charset = Charset.forName("UTF-8");
            // reading lines from file to List
            List<String> stringList = Files.readAllLines(filePath, charset);

            // assign each element in list to new Contact
            contact.setId(id);
            contact.setName(stringList.get(0));
            contact.setEmail(stringList.get(1));
            contact.setPhone(stringList.get(2));
            LocalDate dob = LocalDate.parse(stringList.get(3), formatter);
            contact.setBirthDate(dob);

            System.out.println("StringList id: " + stringList);
            // send information back to contact
            model.addAttribute("validContact", contact);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
