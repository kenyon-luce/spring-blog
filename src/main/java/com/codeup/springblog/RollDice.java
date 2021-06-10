package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RollDice {
    @GetMapping("/roll-dice/n")
    public String showForm(){
        return "guess";
    }

    @PostMapping("/roll-dice/n")
    public String guess(@RequestParam(name="n") String n, Model model){
        model.addAttribute("n", n);
        return "guess";
    }
}
