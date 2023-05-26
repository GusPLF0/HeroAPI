package com.hero.application.port.in;

import org.springframework.stereotype.Component;

import java.util.UUID;


public interface SaveHeroUseCase {
     UUID createHero(SaveHeroRequest saveHeroRequest);
}
