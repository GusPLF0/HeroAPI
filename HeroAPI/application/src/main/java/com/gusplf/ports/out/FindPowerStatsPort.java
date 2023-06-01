package com.gusplf.ports.out;

import java.util.UUID;

public interface FindPowerStatsPort {
    UUID findPowerStats(int strength,
                        int agility,
                        int dexterity,
                        int intelligence);
}
