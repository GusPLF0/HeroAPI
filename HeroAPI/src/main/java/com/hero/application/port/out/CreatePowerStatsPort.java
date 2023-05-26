package com.hero.application.port.out;

import org.springframework.stereotype.Component;

import java.util.UUID;

public interface CreatePowerStatsPort {
    UUID createPowerStats(int strength,
                          int agility,
                          int dexterity,
                          int intelligence);
}
