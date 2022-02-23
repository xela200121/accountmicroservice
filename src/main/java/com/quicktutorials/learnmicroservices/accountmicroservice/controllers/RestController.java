package com.quicktutorials.learnmicroservices.accountmicroservice.controllers;

import javax.validation.Valid;

import com.quicktutorials.learnmicroservices.accountmicroservice.entities.User;

import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @RequestMapping("/hello")
    public String sayHello(){
        return "Hello everyone!";
    }

    @RequestMapping("/newuser1")
    public String addUser(User user){
        return "User added correctly:" + user.getId() + ", " + user.getUsername();
    }

    @RequestMapping("/newuser2")
    public String addUserValid(@Valid User user){
        return "User added correctly:" + user.getId() + ", " + user.getUsername();
    }

    @RequestMapping("/newuser3")
    public String addUserValidPlusBinding(@Valid User user, BindingResult result){
        if(result.hasErrors()){
            return result.toString();
        }
        return "User added correctly:" + user.getId() + ", " + user.getUsername();
    }

    @RequestMapping("/newuser4")
    public String addUserValidPlusBinding2(User user, BindingResult result){
        UserValidator userValidator = new UserValidator();
        userValidator.validate(user, result);
        if(result.hasErrors()){
            return result.toString();
        }
        return "User added correctly:" + user.getId() + ", " + user.getUsername();
    }

    private class UserValidator implements Validator {
        
        @Override
        public boolean supports(Class<?> clazz) {
            return User.class.equals(clazz);
        }

        @Override
        public void validate(Object obj, Errors errors) {
            User user = (User) obj;
            if (user.getPassword().length() < 8) {
                errors.rejectValue("password", "the password must be at least 8 chars long!");
            }
        }

    }
    
}
