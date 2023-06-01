package com.gusplf.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "power_stats")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PowerStatsEntity {

    @Id
    @Column(name = "power_stats_id")
    private UUID id;

    @Column(nullable = false)
    private Integer strength;

    @Column(nullable = false)
    private Integer agility;

    @Column(nullable = false)
    private Integer intelligence;

    @Column(nullable = false)
    private Integer dexterity;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

}
