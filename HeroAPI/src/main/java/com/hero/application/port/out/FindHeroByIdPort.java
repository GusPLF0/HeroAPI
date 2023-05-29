package com.hero.application.port.out;

import com.hero.adapter.in.HeroModel;

import java.util.UUID;

public interface FindHeroByIdPort {
    HeroModel findHeroById(UUID heroId);
}
