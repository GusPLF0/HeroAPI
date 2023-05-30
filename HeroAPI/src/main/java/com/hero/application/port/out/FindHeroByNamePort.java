package com.hero.application.port.out;

import com.hero.adapter.in.web.HeroModel;

public interface FindHeroByNamePort {
    HeroModel findHeroByName(String name);
}
