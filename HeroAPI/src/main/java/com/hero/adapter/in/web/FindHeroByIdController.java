package com.hero.adapter.in.web;

import com.hero.adapter.in.web.model.HeroModel;
import com.hero.application.port.in.FindHeroByIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/heroes")
public class FindHeroByIdController {

    private final FindHeroByIdUseCase findHeroByIdUseCase;

    @GetMapping("/{id}")
    public ResponseEntity<HeroModel> findWithId(@Validated @PathVariable UUID id) {
        HeroModel heroById = findHeroByIdUseCase.findHeroById(id);

        if (heroById == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(heroById);
    }
}
