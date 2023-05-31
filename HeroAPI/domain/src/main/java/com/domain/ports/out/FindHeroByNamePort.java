package com.domain.ports.out;

import com.domain.ports.in.model.HeroModel;

public interface FindHeroByNamePort {
    HeroModel findHeroByName(String name);
}
