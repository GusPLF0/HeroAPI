package com.hero.adapter.in.web;

import com.hero.application.port.in.DeleteHeroUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/heroes")
public class DeleteHeroController {

    private final DeleteHeroUseCase deleteHeroUseCase;

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@Validated @PathVariable UUID id) {

        if(deleteHeroUseCase.deleteHero(id)) {
            return ResponseEntity.noContent().build();
        } 

        return ResponseEntity.notFound().build();
    }
}
