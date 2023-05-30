package com.hero.application.port.in;

import com.hero.adapter.in.web.HeroModel;
import com.hero.application.port.in.model.UpdateHeroRequest;

import java.util.UUID;

public interface UpdateHeroUseCase {
    boolean updateHero(UUID heroToUpdate, UpdateHeroRequest updateHeroRequest);
}
