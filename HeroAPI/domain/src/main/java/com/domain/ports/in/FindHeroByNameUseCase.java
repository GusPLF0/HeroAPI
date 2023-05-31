package com.domain.ports.in;

import com.domain.ports.in.model.HeroModel;

public interface FindHeroByNameUseCase {
    HeroModel findHeroByName(String name);
}
