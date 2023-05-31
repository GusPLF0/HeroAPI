package com.domain.ports.in;

import com.domain.ports.in.model.UpdateHeroRequest;

import java.util.UUID;

public interface UpdateHeroUseCase {
    boolean updateHero(UUID heroToUpdate, UpdateHeroRequest updateHeroRequest);
}
