package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RollDice {
    @GetMapping("/roll-dice/{n}")
    public String guess(@PathVariable int n, Model model){
        model.addAttribute("Guess", n);
        return "guess";
    }
}
