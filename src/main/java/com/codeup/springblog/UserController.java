package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @GetMapping("/users/all")
    public String getAllUsers(
            Model model
    ){
        List<User> listOfUsers = new ArrayList<>();

        listOfUsers.add(new User("Samuel","Moore"));
        listOfUsers.add(new User("Andrew","Walsh"));
        listOfUsers.add(new User("Emmanuel","Stephen"));
        listOfUsers.add(new User("Kenyon","Luce"));

        model.addAttribute("users",listOfUsers);

        return "users";
    }

    @GetMapping("/user")
    public String getTheStringUser(
            Model model
    ){
        model.addAttribute("user",new User("Sam","Hirsh"));
        return "users";
    }

}