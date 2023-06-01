package com.gusplf.controllers;

import com.gusplf.ports.in.UpdateHeroUseCase;
import com.gusplf.ports.in.model.UpdateHeroRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/heroes")
public class UpdateHeroController {

    private final UpdateHeroUseCase updateHeroUseCase;

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Validated @PathVariable UUID id,
                                    @Validated @RequestBody UpdateHeroRequest updateHeroRequest) {

        if (updateHeroUseCase.updateHero(id, updateHeroRequest)) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}
