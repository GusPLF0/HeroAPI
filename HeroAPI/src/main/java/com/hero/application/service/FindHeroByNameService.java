package com.hero.application.service;

import com.hero.adapter.in.web.HeroModel;
import com.hero.application.port.in.FindHeroByNameUseCase;
import com.hero.application.port.out.FindHeroByNamePort;
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
