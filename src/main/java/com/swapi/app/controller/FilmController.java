package com.swapi.app.controller;

import com.swapi.app.dto.SwapiFilmByIdResponseDto;
import com.swapi.app.dto.SwapiFilmResponseDto;
import com.swapi.app.service.impl.FilmServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/films")
public class FilmController {

    private final FilmServiceImpl filmService;

    public FilmController(FilmServiceImpl filmService) {
        this.filmService = filmService;
    }

    @GetMapping
    public ResponseEntity<SwapiFilmResponseDto> getFilmsData(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int limit,
            @RequestParam(required = false) String title
    ) {
        return ResponseEntity.ok(filmService.getFilmsData(page, limit, title));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SwapiFilmByIdResponseDto> getFilmDataById(
            @PathVariable int id
    ) {
        return ResponseEntity.ok(filmService.getFilmDataById(id));
    }
}
