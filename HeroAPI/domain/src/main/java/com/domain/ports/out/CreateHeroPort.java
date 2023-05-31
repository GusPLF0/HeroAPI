package com.domain.ports.out;

import com.domain.ports.out.model.CreateHeroCommand;

import java.util.UUID;

public interface CreateHeroPort {
    UUID createHero(CreateHeroCommand hero);
}
