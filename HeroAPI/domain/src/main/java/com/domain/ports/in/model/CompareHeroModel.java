package com.domain.ports.in.model;

import lombok.*;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CompareHeroModel {

    private UUID principalHeroId;

    private UUID comparedHeroId;

    private String strength;

    private String intelligence;

    private String dextery;

    private String agility;
}
