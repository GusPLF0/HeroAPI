package com.gusplf.ports.in;

import com.gusplf.ports.in.model.SaveHeroRequest;

import java.util.UUID;


public interface SaveHeroUseCase {
    UUID createHero(SaveHeroRequest saveHeroRequest);
}
