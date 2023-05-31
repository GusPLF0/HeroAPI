package com.domain.ports.in;

import com.domain.ports.in.model.SaveHeroRequest;

import java.util.UUID;


public interface SaveHeroUseCase {
     UUID createHero(SaveHeroRequest saveHeroRequest);
}
