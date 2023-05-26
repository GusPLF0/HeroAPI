package com.hero.application.port.out;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public interface FindPowerStatsPort {
    UUID findPowerStats(int strength,
                        int agility,
                        int dexterity,
                        int intelligence);
}
