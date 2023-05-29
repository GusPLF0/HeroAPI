package com.hero.application.port.in;

import com.hero.adapter.in.HeroModel;

import java.util.UUID;

public interface FindHeroByIdUseCase {
    HeroModel findHeroById(UUID heroUUID);
}
