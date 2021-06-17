package com.codeup.springblog.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

//@Controller
//public class HelloController {
//    @GetMapping("/hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello from Spring Boot!";
//    }
//
//    @GetMapping("/hello/{name}")
////    @ResponseBody
////    public String helloName(@PathVariable String name){
////        return "Hello from Spring Boot to " + name + "!";
////    }
//    public String helloName(String name, Model model){
//        model.addAttribute("UsersName", name);
//        return "hello_user";
//    }
//}
@Controller
public class  HelloController {

    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hello from Spring Boot to my friends in Marco!";
    }


    //     "Hello from Spring Boot to " + name + " in Marco!";
    @GetMapping("/hello/{name}")
    public String hello(
            @PathVariable String name,
            Model model
    ){

        String bio = "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32.\n";
        model.addAttribute("bio",bio);
        model.addAttribute("UsersName",name);

        return "hello_user";
    }
}