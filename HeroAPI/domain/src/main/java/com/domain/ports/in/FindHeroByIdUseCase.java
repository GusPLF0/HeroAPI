package com.domain.ports.in;

import com.domain.ports.in.model.HeroModel;

import java.util.UUID;

public interface FindHeroByIdUseCase {
    HeroModel findHeroById(UUID heroUUID);
}
