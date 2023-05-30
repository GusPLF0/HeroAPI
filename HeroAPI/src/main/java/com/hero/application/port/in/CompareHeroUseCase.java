package com.hero.application.port.in;

import com.hero.adapter.in.web.model.CompareHeroModel;

import java.util.UUID;

public interface CompareHeroUseCase {
    CompareHeroModel compare(UUID principalHero, UUID comparedHero);
}
