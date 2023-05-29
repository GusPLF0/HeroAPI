package com.hero.application.port.in.save;

import com.hero.application.port.in.save.SaveHeroRequest;

import java.util.UUID;


public interface SaveHeroUseCase {
     UUID createHero(SaveHeroRequest saveHeroRequest);
}
