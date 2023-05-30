package com.hero.application.port.out;

import com.hero.application.port.out.model.CreateHeroCommand;

import java.util.UUID;

public interface CreateHeroPort {
    UUID createHero(CreateHeroCommand hero);
}
