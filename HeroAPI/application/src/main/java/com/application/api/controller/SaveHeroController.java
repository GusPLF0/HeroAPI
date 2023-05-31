package com.application.api.controller;

import com.domain.ports.in.SaveHeroUseCase;
import com.domain.ports.in.model.SaveHeroRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.UUID;

import static java.lang.String.format;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/heroes")
public class SaveHeroController {

    private final SaveHeroUseCase saveHeroUseCase;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody SaveHeroRequest saveHeroRequest) {
        final UUID id = saveHeroUseCase.createHero(saveHeroRequest);
        return ResponseEntity.created(URI.create(format("/api/v1/heroes/%s", id))).build();
    }
}
