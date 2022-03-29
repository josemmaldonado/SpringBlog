package com.codeup.springblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@Controller
public class RollDiceController {


@GetMapping("/roll-dice")
public String RollDice (){
    return "roll-dice";
}


    @GetMapping("/roll-dice/{n}")


    public String GuessNumber(@PathVariable String number, Model model) {
        model.addAttribute("number", number);
        return "roll-dice";
    }
}

