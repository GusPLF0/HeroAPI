package com.gusplf.ports.in;

import com.gusplf.ports.in.model.UpdateHeroRequest;

import java.util.UUID;

public interface UpdateHeroUseCase {
    boolean updateHero(UUID heroToUpdate, UpdateHeroRequest updateHeroRequest);
}
