package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PersonController {

    @GetMapping("/users/all")
    public String getAllUsers(
            Model model
    ){
        List<Person> listOfPeople = new ArrayList<>();

        listOfPeople.add(new Person("Samuel","Moore"));
        listOfPeople.add(new Person("Andrew","Walsh"));
        listOfPeople.add(new Person("Emmanuel","Stephen"));
        listOfPeople.add(new Person("Kenyon","Luce"));

        model.addAttribute("users", listOfPeople);

        return "users";
    }

    @GetMapping("/user")
    public String getTheStringUser(
            Model model
    ){
        model.addAttribute("user",new Person("Sam","Hirsh"));
        return "users";
    }

}