package com.datastorepostgre.repository;

import com.datastorepostgre.entity.HeroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface HeroRepository extends JpaRepository<HeroEntity, UUID> {
    Optional<HeroEntity> findByName(String name);
}
