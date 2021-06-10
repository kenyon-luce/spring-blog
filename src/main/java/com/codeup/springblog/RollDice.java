package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RollDice {
    @GetMapping("/roll-dice")
    public String showJoinForm() {
        return "guess";
    }

    @PostMapping("/roll-dice/{n}")
    public String guess(@PathVariable int n, Model model) {
        model.addAttribute("n", "You guessed " + n + "!");
        return "guess";
    }
}
