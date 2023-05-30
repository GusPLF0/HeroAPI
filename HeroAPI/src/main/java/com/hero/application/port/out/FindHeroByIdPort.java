package com.hero.application.port.out;

import com.hero.adapter.in.web.model.HeroModel;

import java.util.UUID;

public interface FindHeroByIdPort {
    HeroModel findHeroById(UUID heroId);
}
