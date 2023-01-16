package com.day13_Workshop.addressBook.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.Random;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;


// use serializable allows efficient storing and manipulation of data 
// (usually used for applications for legacy code)
public class Contact implements Serializable{
    private static final long serialVersionUID = 1L;
    
    // validation of user information
    @NotNull(message="Name cannot be null")
    @Size(min=3, max=64, message="Name must be 3 - 64 characters")
    private String name;

    @Email(message="Please enter a valid email")
    private String email;

    @Min(value=7, message="Phone number must contain at least 7 digits")
    private String phone;

    @Past(message="Invalid date, must be in the past")
    @NotNull(message="Must input date")
    @DateTimeFormat(pattern="dd-MM-yyyy")
    private LocalDate birthDate;

    @Min(value=10, message="Age should be above 10 years old")
    @Max(value=100, message="Age should be below 100 years old")
    private Integer age;
    
    private String id;

    // Constructor#0 (For initialising empty contact)
    public Contact() {
        this.id = generateId(8);
    }

    // Constructor #1 (generating from form)
    public Contact(String name, String email, String phone, LocalDate birthDate) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.birthDate = birthDate;
        // add method call to calculate and set age

    }
    // Constructor #2 (generating from existing file in data)
    public Contact(String id, String name, String email, String phone, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.birthDate = birthDate;        
    }
    
    // getters and setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
    // set dob, calculate age, call set age
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        // calculating age based on today's value
        Integer ageYears = 0;
        LocalDate today = LocalDate.now();
        Period agePeriod = Period.between(birthDate, today);
        // get year from dob
        if (birthDate != null) {
            ageYears = agePeriod.getYears();
        }
        // get year from today        
        this.age = ageYears;
    }

    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    // method to generate random id
    public synchronized String generateId(int numChars) {
        String newId = "";
        Random rand = new Random();
        
        // while String less than length numChars continue adding
        while (newId.length() < numChars) {
            String num = Integer.toHexString(rand.nextInt());
            newId = newId.concat(num);
        }
        // slice characters
        return newId.substring(0,numChars);
    }

}
