package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;


@Controller
public class DiceController {
    Random random = new Random();
    int roll;

    @GetMapping("/roll-dice")
    public String roll(
            Model model
    ) {

        model.addAttribute("roll", roll);
        return "guess";
    }

    @GetMapping("/roll-dice/{n}")
    public String guess(
            @PathVariable int n,
            Model model
    ) {
        roll = random.nextInt(6) + 1;
        model.addAttribute("roll", roll);
        model.addAttribute("guess", n);

        return "guess";
    }
}
