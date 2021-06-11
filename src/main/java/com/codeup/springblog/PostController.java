package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {
    @GetMapping("/posts")
    @ResponseBody
    public String posts(){
        return "posts index page";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String postId(@PathVariable int id){
        return "view an individual post with id: " + id;
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String postGetCreate(){
        return "view the form for creating the post";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String postPostCreate(){
        return "create a new post";
    }
}
