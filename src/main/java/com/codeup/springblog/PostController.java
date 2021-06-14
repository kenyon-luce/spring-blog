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

        return "posts/index";
        //^returns all ads into view
    }

    @RequestMapping(value = "/services/tasks/addDocument", method = RequestMethod.POST)
    @ResponseBody
    public void set(@RequestParam("title") String title,@RequestParam("body") String body){

// assign parameters to taskDocumentEntity by constructor args or setters
        Post post = new Post();
//        PostRepository.save(post);
        post.setTitle(title);
        post.setBody(body);
    }
//    @PostMapping("/posts")
//    public String index(Model model){
//        model.addAttribute("posts", postDao);
//    }
}