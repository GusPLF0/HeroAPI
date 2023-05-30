package com.hero.adapter.in.web.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class HeroModel {

    private UUID heroId;

    private String name;

    private String race;

    private Integer strength;

    private Integer agility;

    private Integer dexterity;

    private Integer intelligence;

    private Instant createdAt;

    private Instant updatedAt;

    private Boolean enabled;
}
