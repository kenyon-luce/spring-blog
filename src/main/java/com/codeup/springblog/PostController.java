package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    private final PostRepository postDao;

    public PostController(PostRepository postDao){
        this.postDao = postDao;
    }

    @GetMapping("/posts")
    public String index(Model model) {
        model.addAttribute("posts", postDao.findAll());

        return "posts/index"; //needed to initialize model
        //^returns all ads into view
    }

    @GetMapping("/posts/create")
    public String form(){
        return "posts/create"; //directs to the html with the form
    }

    @PostMapping("/posts/create")
    public String create(@RequestParam("title") String title, @RequestParam("body") String body){
        Post post = new Post();
        post.setTitle(title);
        post.setBody(body);

        postDao.save(post); //inserts post into sql
//        return "redirect:/posts/" + savedPost.getId(); //'adds' new post id to the url, this isn't needed since we haven't made a view by id method
        return "redirect:/posts"; //redirects to a url instead of a filepath, compared to line 25
    }

//    @PostMapping("/posts")
//
//    public String newPost(@ModelAttribute Post post) {
//        postDao.save(post);
//        return "redirect:/posts";
//    }
}