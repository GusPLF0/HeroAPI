package com.hero.application.port.in;

import com.hero.adapter.in.web.HeroModel;

import java.util.UUID;

public interface FindHeroByIdUseCase {
    HeroModel findHeroById(UUID heroUUID);
}
