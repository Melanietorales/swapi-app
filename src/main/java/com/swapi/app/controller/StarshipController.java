package com.swapi.app.controller;

import com.swapi.app.dto.StarshipListResponseDto;
import com.swapi.app.service.StarshipService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/starship")
public class StarshipController {

    private final StarshipService starshipService;

    public StarshipController(StarshipService starshipService) {
        this.starshipService = starshipService;
    }

    @GetMapping
    public ResponseEntity<StarshipListResponseDto> getStarshipData(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int limit,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String model
    ) {
        return ResponseEntity.ok(starshipService.getStarshipData(page, limit, name, model));
    }
}
