package com.codeup.springblog;//package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/users/all")
    public String getUsers() {
        return "users";
    }
}