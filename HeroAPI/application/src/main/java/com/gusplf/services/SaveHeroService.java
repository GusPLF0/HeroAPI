package com.gusplf.services;

import com.gusplf.ports.in.SaveHeroUseCase;
import com.gusplf.ports.in.model.SaveHeroRequest;
import com.gusplf.ports.out.CreateHeroPort;
import com.gusplf.ports.out.CreatePowerStatsPort;
import com.gusplf.ports.out.FindPowerStatsPort;
import com.gusplf.ports.out.model.CreateHeroCommand;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
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
