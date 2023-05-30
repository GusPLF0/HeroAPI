package com.hero.application.service;

import com.hero.adapter.in.web.model.HeroModel;
import com.hero.application.port.in.DeleteHeroUseCase;
import com.hero.application.port.out.DeleteHeroPort;
import com.hero.application.port.out.FindHeroByIdPort;
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
