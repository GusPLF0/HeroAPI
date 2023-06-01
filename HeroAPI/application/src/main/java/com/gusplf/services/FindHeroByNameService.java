package com.gusplf.services;

import com.gusplf.ports.in.FindHeroByNameUseCase;
import com.gusplf.ports.in.model.HeroModel;
import com.gusplf.ports.out.FindHeroByNamePort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FindHeroByNameService implements FindHeroByNameUseCase {


    private final FindHeroByNamePort findHeroByNamePort;

    @Override
    public HeroModel findHeroByName(String name) {
        return findHeroByNamePort.findHeroByName(name);
    }
}
