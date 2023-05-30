package com.hero.application.port.in;

import com.hero.application.port.in.model.SaveHeroRequest;

import java.util.UUID;


public interface SaveHeroUseCase {
     UUID createHero(SaveHeroRequest saveHeroRequest);
}
