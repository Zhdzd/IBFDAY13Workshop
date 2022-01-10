package com.example.Day13Workshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.Day13Workshop.model.Contact;
import com.example.Day13Workshop.util.Contacts;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.ApplicationArguments;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class AddressBookController {
    private static final Logger logger = LoggerFactory.getLogger(AddressBookController.class);
    @Autowired
    private ApplicationArguments applicationArguments;

    @GetMapping("/")
    public String contactForm(Model model){
        model.addAttribute("contact", new Contact());
        return "contact";
    }
    @GetMapping("/getContact/{contactId}")
    public String getContact(Model model, @PathVariable(value="contactId") String contactId){
        logger.info("contactId > " + contactId);
        Contacts ct = new Contacts();
       ct.getContactById(model, contactId, applicationArguments);
        return "showContact";
    }

    @PostMapping("/contact")
    public String contactSubmit(@ModelAttribute Contact contact, Model model){
        try{
        logger.info("Name > " + contact.getName());
        logger.info("Email > " + contact.getEmail());
        logger.info("Phone Number > " +contact.getPhoneNumber());
        Contacts ct = new Contacts();
        ct.saveContact(contact, model, applicationArguments);
        }catch(Exception e){
            model.addAttribute("error message", "try again!");
            
        }
        return "showContact";
    }
}
