package com.hero.adapter.out.persistence;

import com.hero.adapter.in.web.HeroModel;
import com.hero.application.port.out.*;
import com.hero.application.port.out.model.CreateHeroCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class HeroPersistenceAdapter implements
        CreateHeroPort,
        CreatePowerStatsPort,
        FindPowerStatsPort,
        FindHeroByIdPort,
        FindHeroByNamePort {

    private final HeroRepository heroRepository;
    private final PowerStatsRepository powerStatsRepository;


    @Override
    public UUID createHero(CreateHeroCommand hero) {
        HeroEntity heroToSave = new HeroEntity(
                UUID.randomUUID(),
                hero.getName(),
                hero.getRace().toString(),
                hero.getPowerStatsUuid(),
                Instant.now(),
                Instant.now(),
                true);

        return heroRepository.save(heroToSave).getHeroId();
    }

    @Override
    public UUID createPowerStats(int strength, int agility, int dexterity, int intelligence) {
        PowerStatsEntity powerStatsEntity = new PowerStatsEntity(
                UUID.randomUUID(),
                strength,
                agility,
                dexterity,
                intelligence,
                Instant.now(),
                Instant.now());

        PowerStatsEntity savedPowerStats = powerStatsRepository.save(powerStatsEntity);

        return savedPowerStats.getId();
    }

    @Override
    public UUID findPowerStats(int strength, int agility, int dexterity, int intelligence) {
        UUID findedPowerStats = powerStatsRepository.findByStats(
                strength,
                agility,
                dexterity,
                intelligence);

        return findedPowerStats;
    }

    @Override
    public HeroModel findHeroById(UUID heroId) {
        HeroEntity heroFounded = heroRepository.findById(heroId).orElse(null);

        if (heroFounded == null) {
            return null;
        }

        PowerStatsEntity powerStatsOfFounded = powerStatsRepository.findById(heroFounded.getPowerStatsId()).get();

        return new HeroModel(heroFounded.getHeroId(),
                heroFounded.getName(),
                heroFounded.getRace(),
                powerStatsOfFounded.getStrength(),
                powerStatsOfFounded.getAgility(),
                powerStatsOfFounded.getDexterity(),
                powerStatsOfFounded.getIntelligence(),
                heroFounded.getCreatedAt(),
                heroFounded.getUpdatedAt(),
                heroFounded.getEnabled()
        );
    }

    @Override
    public HeroModel findHeroByName(String name) {
        HeroEntity heroFounded = heroRepository.findByName(name).orElse(null);

        if (heroFounded == null) {
            return null;
        }

        PowerStatsEntity powerStatsOfFounded = powerStatsRepository.findById(heroFounded.getPowerStatsId()).get();

        return new HeroModel(heroFounded.getHeroId(),
                heroFounded.getName(),
                heroFounded.getRace(),
                powerStatsOfFounded.getStrength(),
                powerStatsOfFounded.getAgility(),
                powerStatsOfFounded.getDexterity(),
                powerStatsOfFounded.getIntelligence(),
                heroFounded.getCreatedAt(),
                heroFounded.getUpdatedAt(),
                heroFounded.getEnabled()
        );
    }
}
