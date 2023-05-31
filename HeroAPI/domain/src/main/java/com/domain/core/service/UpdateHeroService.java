package com.domain.core.service;

import com.domain.core.domain.Race;
import com.domain.ports.in.UpdateHeroUseCase;
import com.domain.ports.in.model.HeroModel;
import com.domain.ports.in.model.UpdateHeroRequest;
import com.domain.ports.out.CreatePowerStatsPort;
import com.domain.ports.out.FindHeroByIdPort;
import com.domain.ports.out.FindPowerStatsPort;
import com.domain.ports.out.UpdateHeroPort;
import com.domain.ports.out.model.UpdateHeroCommand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.UUID;

@AllArgsConstructor
@Component
public class UpdateHeroService implements UpdateHeroUseCase {

    private final UpdateHeroPort updateHeroPort;
    private final FindHeroByIdPort findHeroByIdPort;
    private final FindPowerStatsPort findPowerStatsPort;
    private final CreatePowerStatsPort createPowerStatsPort;

    private static void verifyAndChangeHeroFound(UpdateHeroRequest updateHeroRequest, HeroModel heroFound) {
        if (updateHeroRequest.getAgility() != null) {
            heroFound.setAgility(updateHeroRequest.getAgility());
        }
        if (updateHeroRequest.getIntelligence() != null) {
            heroFound.setIntelligence(updateHeroRequest.getIntelligence());
        }
        if (updateHeroRequest.getDexterity() != null) {
            heroFound.setDexterity(updateHeroRequest.getDexterity());
        }
        if (updateHeroRequest.getStrength() != null) {
            heroFound.setStrength(updateHeroRequest.getStrength());
        }
        if (updateHeroRequest.getRace() != null) {
            heroFound.setRace(updateHeroRequest.getRace().toString());
        }
        if (updateHeroRequest.getName() != null) {
            heroFound.setName(updateHeroRequest.getName());
        }
        if (updateHeroRequest.getEnabled() != null) {
            heroFound.setEnabled(updateHeroRequest.getEnabled());
        }
    }

    @Override
    public boolean updateHero(UUID heroToUpdate, UpdateHeroRequest updateHeroRequest) {
        HeroModel heroFound = findHeroByIdPort.findHeroById(heroToUpdate);

        if (heroFound == null) {
            return false;
        }

        verifyAndChangeHeroFound(updateHeroRequest, heroFound);

        UpdateHeroCommand updateHeroCommand = updateHeroCommandFromHeroModel(heroFound);


        updateHeroPort.updateHero(updateHeroCommand);

        return true;
    }

    private UpdateHeroCommand updateHeroCommandFromHeroModel(HeroModel heroFound) {
        UpdateHeroCommand updateHeroCommand = new UpdateHeroCommand();

        updateHeroCommand.setUpdatedAt(Instant.now());

        if (findPowerStatsPort.findPowerStats(heroFound.getStrength(),
                heroFound.getAgility(),
                heroFound.getDexterity(),
                heroFound.getIntelligence()) == null) {

            UUID powerStats = createPowerStatsPort.createPowerStats(heroFound.getStrength(),
                    heroFound.getAgility(),
                    heroFound.getDexterity(),
                    heroFound.getIntelligence());

            updateHeroCommand.setHeroUuid(heroFound.getHeroId());
            updateHeroCommand.setName(heroFound.getName());
            updateHeroCommand.setRace(Race.valueOf(heroFound.getRace()));
            updateHeroCommand.setPowerStatsUuid(powerStats);
            updateHeroCommand.setEnabled(heroFound.getEnabled());
            updateHeroCommand.setCreatedAt(heroFound.getCreatedAt());
        } else {
            updateHeroCommand.setHeroUuid(heroFound.getHeroId());
            updateHeroCommand.setName(heroFound.getName());
            updateHeroCommand.setRace(Race.valueOf(heroFound.getRace()));
            updateHeroCommand.setPowerStatsUuid(findPowerStatsPort.findPowerStats(heroFound.getStrength(),
                    heroFound.getAgility(),
                    heroFound.getDexterity(),
                    heroFound.getIntelligence()));
            updateHeroCommand.setEnabled(heroFound.getEnabled());
            updateHeroCommand.setCreatedAt(heroFound.getCreatedAt());
        }

        return updateHeroCommand;
    }
}
