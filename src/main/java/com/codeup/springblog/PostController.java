package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    private final PostRepository postDao;
    private final UserRepository userDao;

    public PostController(PostRepository postDao, UserRepository userDao){ //injected user repo
        this.postDao = postDao;
        this.userDao = userDao;
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
        User owner = userDao.getById(1L); //not sure what this does, looks like it looks at the id each post is associated with

        Post post = new Post(title, body, owner);
//        post.setTitle(title);
//        post.setBody(body);

        postDao.save(post); //inserts post into sql
//        return "redirect:/posts/" + savedPost.getId(); //'adds' new post id to the url, this isn't needed since we haven't made a view by id method
        return "redirect:/posts"; //redirects to a url instead of a filepath, compared to line 25
    }

    @GetMapping("/posts/{id}")
    public String post(@PathVariable long id, Model model) {
        model.addAttribute("post", postDao.getById(id));
        return "posts/show";
    }
}