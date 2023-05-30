package com.hero.application.port.out;

import com.hero.application.port.out.model.UpdateHeroCommand;

public interface UpdateHeroPort {
    void updateHero(UpdateHeroCommand updateHeroCommand);
}
