package com.domain.core.service;

import com.domain.ports.in.DeleteHeroUseCase;
import com.domain.ports.in.model.HeroModel;
import com.domain.ports.out.DeleteHeroPort;
import com.domain.ports.out.FindHeroByIdPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@RequiredArgsConstructor
@Component
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
