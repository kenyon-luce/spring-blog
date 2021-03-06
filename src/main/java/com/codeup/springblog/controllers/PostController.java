package com.codeup.springblog.controllers;

import com.codeup.springblog.daos.PostRepository;
import com.codeup.springblog.daos.UserRepository;
import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.User;
import com.codeup.springblog.services.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    private final PostRepository postDao;
    private final UserRepository userDao;
    private final EmailService emailService;

    public PostController(PostRepository postDao, UserRepository userDao, EmailService emailService) { //injected user repo
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
    }

    @GetMapping("/posts")
    public String index(Model model) {
        model.addAttribute("posts", postDao.findAll());

        return "posts/index"; //needed to initialize model
        //^returns all ads into view
    }

//    @GetMapping("/posts/create")
//    public String createForm(){
//        return "posts/create"; //directs to the html with the form
//    }



//    @PostMapping("/posts/create")
//    public String create(@RequestParam("title") String title, @RequestParam("body") String body) {
//        User owner = userDao.getById(1L); //not sure what this does, looks like it looks at the id each post is associated with
//
//        Post post = new Post(title, body, owner);
//
//        postDao.save(post); //inserts post into sql
////        return "redirect:/posts/" + savedPost.getId(); //'adds' new post id to the url, this isn't needed since we haven't made a view by id method
//        return "redirect:/posts"; //redirects to a url instead of a filepath, compared to line 25
//    }

    //RECREATING GET MAPPING USING FORM MODEL BONDING (start)
    @GetMapping("/posts/create")
    public String createForm(Model model){
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String create(@ModelAttribute Post post){
        User user = userDao.getById(1L);
        post.setOwner(user);
        Post savedPost = postDao.save(post);
        emailService.prepareAndSend(savedPost, "testing", "testing body");
        return "redirect:/posts";// + savedPost.getId();
    }
    //RECREATING GET MAPPING USING FORM MODEL BONDING (end)

    @GetMapping("/posts/{id}")
    public String post(@PathVariable long id, Model model) {
        model.addAttribute("post", postDao.getById(id)); //postDao is needed to iterate through the SQL posts table and grab the post with a passed id
        return "posts/show";
    }

    @GetMapping("/posts/edit/{id}")
    public String editForm(@PathVariable long id, Model model) {
        model.addAttribute("post", postDao.getById(id));
        return "posts/edit";
    }

    @PostMapping("/posts/edit/{id}")
    public String edit(@PathVariable long id, @ModelAttribute Post post, Model model) {
//        model.addAttribute("post", postDao.getById(id));
        postDao.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/delete/{id}")
    public String delete(@PathVariable long id) {
        postDao.deleteById(id);
        return "redirect:/posts";
        //since we deleted some posts, the ids are no longer in order, making a function that reorders the ids is not recommended because other tables may depend on these ids, maybe make a list function instead that doesn't refer to each posts id
    }

    @GetMapping("/posts/clear")
    public String clear(){
        postDao.deleteAll();
        return "redirect:/posts";
    }
}