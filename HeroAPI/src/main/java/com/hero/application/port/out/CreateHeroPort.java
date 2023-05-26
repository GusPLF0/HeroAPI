package com.hero.application.port.out;

import com.hero.domain.Hero;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public interface CreateHeroPort {
    UUID createHero(CreateHeroCommand hero);
}
