package com.hero.application.service;

import com.hero.adapter.in.web.HeroModel;
import com.hero.application.port.out.FindHeroByIdPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.util.UUID;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindHeroByIdServiceTest {

    @Mock
    private FindHeroByIdPort findHeroByIdPort;

    private FindHeroByIdService subject;

    @BeforeEach
    void setUp() {
        subject = new FindHeroByIdService(findHeroByIdPort);
    }

    // nota: testar apenas o que a classe realmente faz, nesse caso: chamar o repository
    @Test
    void findHero_withValidUuid_shouldCallFindHeroByIdPort() {
        // Given
        final HeroModel heroModel = new HeroModel(UUID.fromString("dc38ff64-fed0-4593-b639-2536215b2ae3"), "name",
                "race", 1, 1, 1, 1, Instant.now(),
                Instant.now(), false);

        when(findHeroByIdPort.findHeroById(UUID.fromString("4e289b93-c484-40b5-95a4-3c58bf6d4b9d")))
                .thenReturn(heroModel);

        // When
        final HeroModel result = subject.findHeroById(
                UUID.fromString("4e289b93-c484-40b5-95a4-3c58bf6d4b9d"));

    }
}
