package com.datastorepostgre.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "hero")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HeroEntity {

    @Id
    @Column(name = "hero_id")
    private UUID heroId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String race;

    @Column(name = "power_stats_id", nullable = false)
    private UUID powerStatsId;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    @Column()
    private Boolean enabled;

}
