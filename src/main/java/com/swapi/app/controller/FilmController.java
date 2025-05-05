package com.swapi.app.controller;

import com.swapi.app.client.impl.FilmClientImpl;
import com.swapi.app.dto.SwapiFilmByIdResponseDto;
import com.swapi.app.dto.SwapiFilmResponseDto;
import com.swapi.app.service.impl.FilmServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/films")
public class FilmController {

    private static final Logger logger = LoggerFactory.getLogger(FilmController.class);
    private final FilmServiceImpl filmService;

    public FilmController(FilmServiceImpl filmService) {
        this.filmService = filmService;
    }

    @GetMapping
    @Operation(summary = "Get all films", description = "Retrieve a list of films.")
    public ResponseEntity<SwapiFilmResponseDto> getFilmsData(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int limit,
            @RequestParam(required = false) String title
    ) {
        logger.info("FilmController - getFilmsData - page: {}, limit: {}, title: {}", page, limit, title);
        return ResponseEntity.ok(filmService.getFilmsData(page, limit, title));
    }

    @Operation(summary = "Get film by ID", description = "Retrieve details of a film by its ID.")
    @GetMapping("/{id}")
    public ResponseEntity<SwapiFilmByIdResponseDto> getFilmDataById(
            @PathVariable int id
    ) {
        logger.info("FilmController - getFilmDataById - id: {}", id);
        return ResponseEntity.ok(filmService.getFilmDataById(id));
    }
}
