package com.example.td1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Dice {
    private final int sides;

    public Dice(int sides) {
        this.sides = sides;
    }

    public Dice(){
        this.sides = 6;
    }

    public int roll() {
        return (int) (Math.random() * this.sides) + 1;
    }
}

