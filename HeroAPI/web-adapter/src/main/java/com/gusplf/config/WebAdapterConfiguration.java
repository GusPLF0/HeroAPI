package com.gusplf.config;

import com.gusplf.controllers.FindHeroByIdController;
import com.gusplf.ports.in.FindHeroByIdUseCase;
import com.gusplf.ports.out.FindHeroByIdPort;
import com.gusplf.services.FindHeroByIdService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebAdapterConfiguration {
    private final FindHeroByIdUseCase findHeroByIdUseCase;

    public WebAdapterConfiguration(FindHeroByIdUseCase findHeroByIdUseCase) {
        this.findHeroByIdUseCase = findHeroByIdUseCase;
    }

    @Bean
    public FindHeroByIdUseCase findHeroByIdUseCase(FindHeroByIdPort findHeroByIdPort) {
        return new FindHeroByIdService(findHeroByIdPort);
    }

    @Bean
    public FindHeroByIdController findHeroByIdController() {
        return new FindHeroByIdController(findHeroByIdUseCase);
    }
}
