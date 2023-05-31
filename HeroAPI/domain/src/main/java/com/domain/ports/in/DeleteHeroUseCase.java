package com.domain.ports.in;

import java.util.UUID;

public interface DeleteHeroUseCase {
    boolean deleteHero(UUID heroIdToDelete);
}
