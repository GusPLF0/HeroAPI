package com.hero.application.service;

import com.hero.application.port.in.SaveHeroRequest;
import com.hero.application.port.in.SaveHeroUseCase;
import com.hero.application.port.out.CreateHeroCommand;
import com.hero.application.port.out.CreateHeroPort;
import com.hero.application.port.out.CreatePowerStatsPort;
import com.hero.application.port.out.FindPowerStatsPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@RequiredArgsConstructor
@Component
public class SaveHeroService implements SaveHeroUseCase {

    private final CreateHeroPort createHeroPort;
    private final FindPowerStatsPort findPowerStatsPort;
    private final CreatePowerStatsPort createPowerStatsPort;


    @Override
    public UUID createHero(SaveHeroRequest saveHeroRequest) {
        UUID powerStatsFinded = findPowerStats(saveHeroRequest);
        CreateHeroCommand heroToSave;

        if (powerStatsFinded != null) {
            heroToSave = createHeroToSave(saveHeroRequest, powerStatsFinded);
        } else {
            UUID newPowerStats = createNewPowerStatsForHero(saveHeroRequest);
            heroToSave = createHeroToSave(saveHeroRequest, newPowerStats);
        }

        return createHeroPort.createHero(heroToSave);
    }

    private static CreateHeroCommand createHeroToSave(SaveHeroRequest saveHeroRequest, UUID powerStats) {
        return new CreateHeroCommand(
                saveHeroRequest.getName(),
                saveHeroRequest.getRace(),
                powerStats
        );
    }

    private UUID createNewPowerStatsForHero(SaveHeroRequest saveHeroRequest) {
        return createPowerStatsPort.createPowerStats(saveHeroRequest.getStrength(),
                saveHeroRequest.getAgility(),
                saveHeroRequest.getDexterity(),
                saveHeroRequest.getIntelligence());
    }

    private UUID findPowerStats(SaveHeroRequest saveHeroRequest) {
        return findPowerStatsPort.findPowerStats(
                saveHeroRequest.getStrength(),
                saveHeroRequest.getAgility(),
                saveHeroRequest.getDexterity(),
                saveHeroRequest.getIntelligence());
    }
}
