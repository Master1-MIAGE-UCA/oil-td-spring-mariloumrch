package com.example.td1;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.List;

@Entity
public class DiceRollLog {
    @Id
    @GeneratedValue
    private long id;

    private int diceCount;

    @ElementCollection
    private List<Integer> results;

    @CreationTimestamp
    private LocalDate aLocalDate;

    public DiceRollLog() {}

    public DiceRollLog(List<Integer>results) {
        this.results = results;
        this.diceCount = results.size();
        this.aLocalDate = LocalDate.now();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getDiceCount() {
        return diceCount;
    }

    public void setDiceCount(int diceCount) {
        this.diceCount = diceCount;
    }

    public List<Integer> getResults() {
        return results;
    }

    public void setResults(List<Integer> results) {
        this.results = results;
    }

    public LocalDate getaLocalDate() {
        return aLocalDate;
    }

    public void setaLocalDate(LocalDate aLocalDate) {
        this.aLocalDate = aLocalDate;
    }
}
