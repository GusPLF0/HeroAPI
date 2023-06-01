package com.gusplf.ports.in;

import com.gusplf.ports.in.model.HeroModel;

public interface FindHeroByNameUseCase {
    HeroModel findHeroByName(String name);
}
