package com.gusplf.ports.out;

import com.gusplf.ports.in.model.HeroModel;

import java.util.UUID;

public interface FindHeroByIdPort {
    HeroModel findHeroById(UUID heroId);
}
