package com.domain.ports.out;

import com.domain.ports.in.model.HeroModel;

import java.util.UUID;

public interface FindHeroByIdPort {
    HeroModel findHeroById(UUID heroId);
}
