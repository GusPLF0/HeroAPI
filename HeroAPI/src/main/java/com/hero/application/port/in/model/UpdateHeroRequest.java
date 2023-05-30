package com.hero.application.port.in.model;

import com.hero.domain.Race;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UpdateHeroRequest {

    private String name;

    private Race race;

    private Integer strength;

    private Integer agility;

    private Integer dexterity;

    private Integer intelligence;

    private Boolean enabled;

}
