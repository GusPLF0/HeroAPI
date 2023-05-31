package com.domain.ports.out;

import com.domain.ports.out.model.UpdateHeroCommand;

public interface UpdateHeroPort {
    void updateHero(UpdateHeroCommand updateHeroCommand);
}
