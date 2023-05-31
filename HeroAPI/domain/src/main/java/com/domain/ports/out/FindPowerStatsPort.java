package com.domain.ports.out;

import org.springframework.stereotype.Component;

import java.util.UUID;

public interface FindPowerStatsPort {
    UUID findPowerStats(int strength,
                        int agility,
                        int dexterity,
                        int intelligence);
}
