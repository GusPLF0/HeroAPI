package com.domain.core.service;

import com.domain.ports.in.FindHeroByNameUseCase;
import com.domain.ports.in.model.HeroModel;
import com.domain.ports.out.FindHeroByNamePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class FindHeroByNameService implements FindHeroByNameUseCase {


    private final FindHeroByNamePort findHeroByNamePort;

    @Override
    public HeroModel findHeroByName(String name) {
        return findHeroByNamePort.findHeroByName(name);
    }
}
