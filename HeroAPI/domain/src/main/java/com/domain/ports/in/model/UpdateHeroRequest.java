package com.domain.ports.in.model;

import com.domain.core.domain.Race;
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
