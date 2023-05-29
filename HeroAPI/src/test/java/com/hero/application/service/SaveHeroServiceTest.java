package com.hero.application.service;

import com.hero.application.port.in.save.SaveHeroRequest;
import com.hero.application.port.out.CreateHeroCommand;
import com.hero.application.port.out.CreateHeroPort;
import com.hero.application.port.out.CreatePowerStatsPort;
import com.hero.application.port.out.FindPowerStatsPort;
import com.hero.domain.Race;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SaveHeroServiceTest {

    @Mock
    private CreateHeroPort createHeroPort;
    @Mock
    private FindPowerStatsPort findPowerStatsPort;
    @Mock
    private CreatePowerStatsPort createPowerStatsPort;

    private SaveHeroService subject;

    @BeforeEach
    void setUp() {
        subject = new SaveHeroService(createHeroPort, findPowerStatsPort,
                createPowerStatsPort);
    }

    @Test
    void createHero_withNonExistingPowerStats_shouldCallCreateHeroPortWithNewPowerStats() {
        // Given
        final SaveHeroRequest saveHeroRequest = new SaveHeroRequest("name", Race.HUMAN, 1, 1, 1, 1);
        final UUID uuidForPowerStats = UUID.fromString("5e4ef27d-0926-43d7-b0ed-97b332c45182");
        final UUID uuidForHero = UUID.fromString("0d606ca6-7da7-444c-a6b3-d33163ba1692");
        when(findPowerStatsPort.findPowerStats(1, 1, 1, 1)).thenReturn(uuidForPowerStats);
        when(createHeroPort.createHero(new CreateHeroCommand("name", Race.HUMAN,
                UUID.fromString("5e4ef27d-0926-43d7-b0ed-97b332c45182")))).thenReturn(uuidForHero);

        // When
        final UUID result = subject.createHero(saveHeroRequest);

        // Then
        assertThat(result).isEqualTo(UUID.fromString("0d606ca6-7da7-444c-a6b3-d33163ba1692"));
    }

    @Test
    void createHero_withExistingPowerStats_shouldCallCreateHeroPortWithExistingPowerStats() {
        // Given
        final SaveHeroRequest saveHeroRequest = new SaveHeroRequest("name", Race.HUMAN, 1, 1,1, 1);
        final UUID uuid = UUID.fromString("55ba55ff-16f3-4b3f-8e22-bc603ddb6e0e");
        final UUID uuid1 = UUID.fromString("ee26f7b0-21b2-4624-b7d5-e84ea8a4e080");

        when(findPowerStatsPort.findPowerStats(1, 1, 1, 1)).thenReturn(null);

        when(createPowerStatsPort.createPowerStats(1, 1, 1, 1)).thenReturn(uuid);

        when(createHeroPort.createHero(new CreateHeroCommand("name", Race.HUMAN,
                UUID.fromString("55ba55ff-16f3-4b3f-8e22-bc603ddb6e0e")))).thenReturn(uuid1);

        // When
        final UUID result = subject.createHero(saveHeroRequest);

        // Then
        assertThat(result).isEqualTo(UUID.fromString("ee26f7b0-21b2-4624-b7d5-e84ea8a4e080"));
    }

}
