package com.gusplf.ports.out;

import java.util.UUID;

public interface CreatePowerStatsPort {
    UUID createPowerStats(int strength,
                          int agility,
                          int dexterity,
                          int intelligence);
}
