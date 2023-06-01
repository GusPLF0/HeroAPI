package com.gusplf.entities;


import lombok.Value;

public class PowerStats {
    private PowerStatsId id;
    private int strength;
    private int agility;
    private int dexterity;
    private int intelligence;

    public PowerStats(PowerStatsId id, int strength, int agility, int dexterity, int intelligence) {
        this.id = id;
        this.strength = strength;
        this.agility = agility;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    public PowerStats(int strength, int agility, int dexterity, int intelligence) {
        this.id = null;
        this.strength = strength;
        this.agility = agility;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    public PowerStatsId getId() {
        return id;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }

    @Value
    public static class PowerStatsId {
        Long value;
    }

}
