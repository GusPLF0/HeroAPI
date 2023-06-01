package com.gusplf.services;

import com.gusplf.ports.in.FindHeroByIdUseCase;
import com.gusplf.ports.in.model.HeroModel;
import com.gusplf.ports.out.FindHeroByIdPort;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class FindHeroByIdService implements FindHeroByIdUseCase {

    private final FindHeroByIdPort findHeroByIdPort;

    @Override
    public HeroModel findHeroById(UUID heroUUID) {
        return findHeroByIdPort.findHeroById(heroUUID);
    }
}
