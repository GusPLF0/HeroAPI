package com.hero.application.port.in;

import java.util.UUID;

public interface DeleteHeroUseCase {
    boolean deleteHero(UUID heroIdToDelete);
}
