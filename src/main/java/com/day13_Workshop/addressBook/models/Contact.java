package com.day13_Workshop.addressBook.models;

import java.io.Serializable;
import java.time.LocalDate;

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

    @NotNull(message="Must input date")
    @Past(message="Invalid date, must be in the past")
    @DateTimeFormat(pattern="dd-MM-yyyy")
    private LocalDate birthDate;

    @Min(value=10, message="Age should be above 10 years old")
    @Max(value=100, message="Age should be below 100 years old")
    private Integer age;
    
    private String id;


    // methods for class
    
    
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
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
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
    

}
