package com.hero.application.service;

import com.hero.adapter.in.web.model.CompareHeroModel;
import com.hero.adapter.in.web.model.HeroModel;
import com.hero.application.port.in.CompareHeroUseCase;
import com.hero.application.port.out.FindHeroByIdPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@RequiredArgsConstructor
@Component
public class CompareHeroService implements CompareHeroUseCase {

    private final FindHeroByIdPort findHeroByIdPort;

    @Override
    public CompareHeroModel compare(UUID principalHero, UUID comparedHero) {
        HeroModel firstHero = findHeroByIdPort.findHeroById(principalHero);
        HeroModel secondHero = findHeroByIdPort.findHeroById(comparedHero);

        if (firstHero == null || secondHero == null) {
            return null;
        }

        return buildComparation(firstHero, secondHero);
    }

    private CompareHeroModel buildComparation(HeroModel firstHero, HeroModel secondHero) {
        return CompareHeroModel.builder()
                .principalHeroId(firstHero.getHeroId())
                .comparedHeroId(secondHero.getHeroId())
                .intelligence(verifyTheDifference(firstHero.getIntelligence(), secondHero.getIntelligence()))
                .strength(verifyTheDifference(firstHero.getStrength(), secondHero.getStrength()))
                .agility(verifyTheDifference(firstHero.getAgility(), secondHero.getAgility()))
                .dextery(verifyTheDifference(firstHero.getDexterity(), secondHero.getDexterity())).build();
    }

    private String verifyTheDifference(Integer statusOfHeroOne, Integer statusOfHeroTwo) {
        if (statusOfHeroOne.compareTo(statusOfHeroTwo) == 0){
            return "=";
        } else if (statusOfHeroOne.compareTo(statusOfHeroTwo) > 0) {
            return "+";
        } else {
            return "-";
        }
    }
}
