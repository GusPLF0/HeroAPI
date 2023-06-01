package com.gusplf.config;

import com.gusplf.adapter.HeroPersistenceAdapter;
import com.gusplf.repos.HeroRepository;
import com.gusplf.repos.PowerStatsRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackageClasses = {HeroRepository.class, PowerStatsRepository.class})
public class PersistenceAdapterConfiguration {

    @Bean
    HeroPersistenceAdapter heroPersistenceAdapter(
            HeroRepository heroRepository,
            PowerStatsRepository powerStatsRepository
    ) {
        return new HeroPersistenceAdapter(
                heroRepository,
                powerStatsRepository
        );
    }
}
