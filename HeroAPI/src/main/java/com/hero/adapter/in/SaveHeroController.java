package com.hero.adapter.in;

import com.hero.application.port.in.save.SaveHeroRequest;
import com.hero.application.port.in.save.SaveHeroUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.UUID;

import static java.lang.String.format;
import static org.springframework.http.ResponseEntity.created;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/heroes")
public class SaveHeroController {

    private final SaveHeroUseCase saveHeroUseCase;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody SaveHeroRequest saveHeroRequest) {
        final UUID id = saveHeroUseCase.createHero(saveHeroRequest);
        return created(URI.create(format("/api/v1/heroes/%s", id))).build();
    }
}
