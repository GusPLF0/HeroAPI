package com.hero.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

public interface HeroRepository extends JpaRepository<HeroEntity, UUID> {
    Optional<HeroEntity> findByName(String name);
}
