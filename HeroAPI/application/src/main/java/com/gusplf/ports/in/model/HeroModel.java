package com.gusplf.ports.in.model;

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
