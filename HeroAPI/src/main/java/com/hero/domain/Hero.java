package com.hero.domain;

import lombok.Value;


public class Hero {
    private HeroId id;
    private String name;
    private Race race;
    private PowerStats powerStats;


    public Hero(HeroId id, String name, Race race, PowerStats powerStats) {
        this.id = id;
        this.name = name;
        this.race = race;
        this.powerStats = powerStats;
    }

    public Hero(String name, Race race, PowerStats powerStats) {
        this.id = null;
        this.name = name;
        this.race = race;
        this.powerStats = powerStats;
    }

    public Hero(String name, Race race) {
        this.id = null;
        this.name = name;
        this.race = race;
        this.powerStats = null;
    }

    public HeroId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Race getRace() {
        return race;
    }

    public PowerStats getPowerStats() {
        return powerStats;
    }

    @Value
    public static class HeroId {
        Long value;
    }
}
