package com.revature.foodstuff.controller;

import javax.mail.internet.MimeMessage;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmailController {
	
	@Autowired
	private JavaMailSender sender;
	
	@RequestMapping("/simpleemail")
    @ResponseBody
    @PostMapping
    public String home(@Valid @RequestBody String email) {
        try {
            sendEmail(email);
            return "Email Sent!";
        }catch(Exception ex) {
            return "Error in sending email: "+ex;
        }
    }
 
    private void sendEmail(String email) throws Exception{
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
         
        helper.setTo(email);
        helper.setText("Welcome!");
        helper.setSubject("Welcome to FoodStuff. Thank you for signing up to be apart of the next best thing! Here at FoodStuff we make it super easy for you to find and share your favorite recipes. We also provide you a space to save them for easy access later. We hope you enjoy using our site. Tell a friend about us!\nSincerely, \nFoodStuff Team");
         
        sender.send(message);
    }

}
