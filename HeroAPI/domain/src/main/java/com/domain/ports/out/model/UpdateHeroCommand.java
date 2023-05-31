package com.domain.ports.out.model;

import com.domain.core.domain.Race;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.time.Instant;
import java.util.UUID;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor()
public class UpdateHeroCommand {

    private UUID heroUuid;

    @NotBlank(message = "message.name.mandatory")
    @Length(min = 1, max = 255, message = "message.name.length")
    private String name;

    @NotNull(message = "message.race.mandatory")
    private Race race;

    @NotNull(message = "message.powerstatsuuid.mandatory")
    private UUID powerStatsUuid;

    private boolean enabled;

    private Instant createdAt;

    private Instant updatedAt;
}
