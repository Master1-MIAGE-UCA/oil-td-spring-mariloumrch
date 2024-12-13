package com.example.td1;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DiceService {
    private final Repository repository;
    private final Dice dice;
    public DiceService(Repository repository, Dice dice) {
        this.repository = repository;
        this.dice = dice;
    }

    @Transactional
    public List<Integer> roll(int nbRoll) {
        List<Integer> results = new ArrayList<>();

        for (int i = 0; i < nbRoll; i++) {
            results.add(dice.roll());
        }
        DiceRollLog dicelog = new DiceRollLog(results);
        repository.save(dicelog);
        return results;
    }

    @Transactional
    public List<DiceRollLog> rollLog() {
     return repository.findAll();
    }
}
