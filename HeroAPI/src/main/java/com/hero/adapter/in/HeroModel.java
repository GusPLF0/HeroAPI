package com.hero.adapter.in;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class HeroModel {

    private UUID heroId;

    private String name;

    private String race;

    private int strength;

    private int agility;

    private int dexterity;

    private int intelligence;

    private Instant createdAt;

    private Instant updatedAt;

    private Boolean enabled;
}
