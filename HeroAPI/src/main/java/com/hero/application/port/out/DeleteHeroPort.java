package com.hero.application.port.out;

import java.util.UUID;

public interface DeleteHeroPort {
    void deleteHero(UUID uuidToDelete);
}
