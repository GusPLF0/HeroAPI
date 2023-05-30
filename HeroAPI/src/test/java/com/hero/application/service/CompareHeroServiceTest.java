package com.hero.application.service;

import com.hero.application.port.out.FindHeroByIdPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class CompareHeroServiceTest {

    @Mock
    private FindHeroByIdPort mockFindHeroByIdPort;

    private CompareHeroService compareHeroServiceUnderTest;

    @BeforeEach
    void setUp() {
        compareHeroServiceUnderTest = new CompareHeroService(mockFindHeroByIdPort);
    }

    @Test
    void testCompare() {
        assertThat(compareHeroServiceUnderTest.compare(UUID.fromString("4a94e721-457d-48ef-89bc-b2d5141277af"),
                UUID.fromString("eb962fcd-fcdc-43b3-be37-2e2b3810f1b5"))).isNull();
    }
}
