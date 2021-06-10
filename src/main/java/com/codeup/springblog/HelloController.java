package com.codeup.springblog;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello from Spring Boot!";
    }

    @GetMapping("/hello/{name}")
//    @ResponseBody
//    public String helloName(@PathVariable String name){
//        return "Hello from Spring Boot to " + name + "!";
//    }
    public String helloName(String name, Model model){
        model.addAttribute("UsersName", name);
        return "hello_user";
    }
}
