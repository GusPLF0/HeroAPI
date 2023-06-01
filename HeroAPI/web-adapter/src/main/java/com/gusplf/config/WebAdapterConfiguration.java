package com.gusplf.config;

import com.gusplf.controllers.FindHeroByIdController;
import com.gusplf.controllers.FindHeroByNameController;
import com.gusplf.ports.in.FindHeroByIdUseCase;
import com.gusplf.ports.in.FindHeroByNameUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebAdapterConfiguration {
    private final FindHeroByIdUseCase findHeroByIdUseCase;
    private final FindHeroByNameUseCase findHeroByNameUseCase;

    public WebAdapterConfiguration(FindHeroByIdUseCase findHeroByIdUseCase, FindHeroByNameUseCase findHeroByNameUseCase) {
        this.findHeroByIdUseCase = findHeroByIdUseCase;
        this.findHeroByNameUseCase = findHeroByNameUseCase;
    }

    @Bean
    public FindHeroByIdController findHeroByIdController() {
        return new FindHeroByIdController(findHeroByIdUseCase);
    }

    @Bean
    public FindHeroByNameController findHeroByNameController() {
        return new FindHeroByNameController(findHeroByNameUseCase);
    }


}
