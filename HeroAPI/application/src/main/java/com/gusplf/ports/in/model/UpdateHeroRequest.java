package com.gusplf.ports.in.model;

import com.gusplf.entities.Race;
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
