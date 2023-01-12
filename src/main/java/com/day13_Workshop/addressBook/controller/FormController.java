package com.day13_Workshop.addressBook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ch.qos.logback.core.model.Model;

@Controller
@RequestMapping(path="/contact-form")
public class FormController {
    
    @GetMapping
    public String getForm(Model model) {

        return "form";
    }
}
