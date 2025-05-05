package com.swapi.app.controller;

import com.swapi.app.dto.StarshipListResponseDto;
import com.swapi.app.dto.SwapiStarshipByIdResponseDto;
import com.swapi.app.service.StarshipService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/starship")
public class StarshipController {

    private final StarshipService starshipService;

    public StarshipController(StarshipService starshipService) {
        this.starshipService = starshipService;
    }

    @Operation(summary = "Get starship data", description = "Retrieve a paginated list of starships. Optionally, filter by name or model.")
    @GetMapping
    public ResponseEntity<StarshipListResponseDto> getStarshipData(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int limit,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String model
    ) {
        return ResponseEntity.ok(starshipService.getStarshipData(page, limit, name, model));
    }

    @Operation(summary = "Get starship by ID", description = "Retrieve details of a starship by its unique ID.")
    @GetMapping("/{id}")
    public ResponseEntity<SwapiStarshipByIdResponseDto> getStarshipById(
            @PathVariable int id
    ) {
        return ResponseEntity.ok(starshipService.getStarshipById(id));
    }
}
