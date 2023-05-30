package com.hero.application.service;

import com.hero.adapter.in.web.model.HeroModel;
import com.hero.application.port.in.FindHeroByIdUseCase;
import com.hero.application.port.out.FindHeroByIdPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@RequiredArgsConstructor
@Component
public class FindHeroByIdService implements FindHeroByIdUseCase {

    private final FindHeroByIdPort findHeroByIdPort;

    @Override
    public HeroModel findHeroById(UUID heroUUID) {
        return findHeroByIdPort.findHeroById(heroUUID);
    }
}
