package com.gusplf.ports.in;

import com.gusplf.ports.in.model.CompareHeroModel;

import java.util.UUID;

public interface CompareHeroUseCase {
    CompareHeroModel compare(UUID principalHero, UUID comparedHero);
}
