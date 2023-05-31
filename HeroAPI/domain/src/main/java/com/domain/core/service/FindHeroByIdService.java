package com.domain.core.service;

import com.domain.ports.in.model.HeroModel;
import com.domain.ports.out.FindHeroByIdPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@RequiredArgsConstructor
@Component
public class FindHeroByIdService implements FindHeroByIdPort {

    private final FindHeroByIdPort findHeroByIdPort;

    @Override
    public HeroModel findHeroById(UUID heroUUID) {
        return findHeroByIdPort.findHeroById(heroUUID);
    }
}
