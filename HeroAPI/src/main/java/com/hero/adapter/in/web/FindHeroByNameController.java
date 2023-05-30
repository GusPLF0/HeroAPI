package com.hero.adapter.in.web;

import com.hero.application.port.in.FindHeroByNameUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/heroes")
public class FindHeroByNameController {

    private final FindHeroByNameUseCase findHeroByNameUseCase;

    @GetMapping()
    public ResponseEntity<HeroModel> findWithName(@Validated @RequestParam String name) {
        HeroModel heroByName = findHeroByNameUseCase.findHeroByName(name);

        if (heroByName == null) {
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.ok(heroByName);
    }
}
