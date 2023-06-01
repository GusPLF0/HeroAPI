package com.gusplf.ports.out;

import com.gusplf.ports.out.model.CreateHeroCommand;

import java.util.UUID;

public interface CreateHeroPort {
    UUID createHero(CreateHeroCommand hero);
}
