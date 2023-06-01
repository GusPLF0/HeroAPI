package com.gusplf.services;

import com.gusplf.ports.in.DeleteHeroUseCase;
import com.gusplf.ports.in.model.HeroModel;
import com.gusplf.ports.out.DeleteHeroPort;
import com.gusplf.ports.out.FindHeroByIdPort;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class DeleteHeroService implements DeleteHeroUseCase {

    private final FindHeroByIdPort findHeroByIdPort;
    private final DeleteHeroPort deleteHeroPort;

    @Override
    public boolean deleteHero(UUID heroIdToDelete) {
        HeroModel heroFound = findHeroByIdPort.findHeroById(heroIdToDelete);

        if (heroFound == null) {
            return false;
        } else {
            deleteHeroPort.deleteHero(heroIdToDelete);
            return true;
        }
    }
}
