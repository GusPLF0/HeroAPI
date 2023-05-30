package com.hero.application.port.in;

import com.hero.adapter.in.web.HeroModel;

public interface FindHeroByNameUseCase {
    HeroModel findHeroByName(String name);
}
