package com.gusplf.ports.out;

import com.gusplf.ports.out.model.UpdateHeroCommand;

public interface UpdateHeroPort {
    void updateHero(UpdateHeroCommand updateHeroCommand);
}
