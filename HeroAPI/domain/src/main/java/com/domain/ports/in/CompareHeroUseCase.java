package com.domain.ports.in;

import com.domain.ports.in.model.CompareHeroModel;

import java.util.UUID;

public interface CompareHeroUseCase {
    CompareHeroModel compare(UUID principalHero, UUID comparedHero);
}
