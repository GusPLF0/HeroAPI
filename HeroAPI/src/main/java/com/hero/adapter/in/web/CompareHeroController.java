package com.hero.adapter.in.web;

import com.hero.adapter.in.web.model.CompareHeroModel;
import com.hero.application.port.in.CompareHeroUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/heroes")
public class CompareHeroController {

    private final CompareHeroUseCase compareHeroUseCase;

    @GetMapping("/{principalHero}/compare/{comparedHero}")
    public ResponseEntity<?> compare(@PathVariable UUID principalHero, @PathVariable UUID comparedHero){
        CompareHeroModel compare = compareHeroUseCase.compare(principalHero, comparedHero);

        if (compare == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(compare);
    }
}
