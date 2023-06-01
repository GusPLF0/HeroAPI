package com.gusplf.repos;

import com.gusplf.entity.PowerStatsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface PowerStatsRepository extends JpaRepository<PowerStatsEntity, UUID> {
    @Query(value = "SELECT power_stats_id FROM power_stats WHERE strength = :strength " +
            "AND agility = :agility AND dexterity = :dexterity AND intelligence = :intelligence",
            nativeQuery = true)
     UUID findByStats(@Param("strength") Integer strength,
                     @Param("agility") Integer agility,
                     @Param("dexterity") Integer dexterity,
                     @Param("intelligence") Integer intelligence);

}
