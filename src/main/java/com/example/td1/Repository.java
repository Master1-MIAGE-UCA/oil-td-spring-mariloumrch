package com.example.td1;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Repository extends JpaRepository<DiceRollLog, Long> {
    DiceRollLog findById(long id);
    List<DiceRollLog> findAllById(int id);
}
