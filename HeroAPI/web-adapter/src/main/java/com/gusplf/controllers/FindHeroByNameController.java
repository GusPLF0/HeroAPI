package com.gusplf.controllers;

import com.gusplf.ports.in.FindHeroByNameUseCase;
import com.gusplf.ports.in.model.HeroModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
