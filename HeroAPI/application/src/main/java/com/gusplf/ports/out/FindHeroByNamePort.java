package com.gusplf.ports.out;

import com.gusplf.ports.in.model.HeroModel;

public interface FindHeroByNamePort {
    HeroModel findHeroByName(String name);
}
