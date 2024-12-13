package com.example.td1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DiceController {
    private final DiceService diceService;

    public DiceController(DiceService diceService) {
        this.diceService = diceService;
    }

    @GetMapping("/rollDice")
    public int rollDice() {
        return diceService.roll(1).get(0);
    }

    @GetMapping("/rollDice/{nbrlance}")
    public List<Integer> rollDice(@PathVariable int nbrlance) {
        return diceService.roll(nbrlance);
    }

    @GetMapping("/log")
    public List<DiceRollLog> log() {
        return this.diceService.rollLog();
    }
}
