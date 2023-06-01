package com.gusplf.ports.in;

import com.gusplf.ports.in.model.HeroModel;

import java.util.UUID;

public interface FindHeroByIdUseCase {
    HeroModel findHeroById(UUID heroUUID);
}
