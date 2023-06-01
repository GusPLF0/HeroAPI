package com.hero;

import com.gusplf.config.PersistenceAdapterConfiguration;
import com.gusplf.config.WebAdapterConfiguration;
import com.gusplf.ports.in.FindHeroByIdUseCase;
import com.gusplf.ports.out.FindHeroByIdPort;
import com.gusplf.services.FindHeroByIdService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({PersistenceAdapterConfiguration.class, WebAdapterConfiguration.class})
public class MainApplicationConfiguration {

    @Bean
    public FindHeroByIdUseCase findHeroByIdUseCase(FindHeroByIdPort findHeroByIdPort) {
        return new FindHeroByIdService(findHeroByIdPort);
    }

}
