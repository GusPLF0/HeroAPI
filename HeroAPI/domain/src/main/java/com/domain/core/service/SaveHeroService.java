package com.domain.core.service;

import com.domain.ports.in.SaveHeroUseCase;
import com.domain.ports.in.model.SaveHeroRequest;
import com.domain.ports.out.CreateHeroPort;
import com.domain.ports.out.CreatePowerStatsPort;
import com.domain.ports.out.FindPowerStatsPort;
import com.domain.ports.out.model.CreateHeroCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@RequiredArgsConstructor
@Component
public class SaveHeroService implements SaveHeroUseCase {

    private final CreateHeroPort createHeroPort;
    private final FindPowerStatsPort findPowerStatsPort;
    private final CreatePowerStatsPort createPowerStatsPort;

    private static CreateHeroCommand createHeroToSave(SaveHeroRequest saveHeroRequest, UUID powerStats) {
        return new CreateHeroCommand(
                saveHeroRequest.getName(),
                saveHeroRequest.getRace(),
                powerStats
        );
    }

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
