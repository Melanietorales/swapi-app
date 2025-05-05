package com.swapi.app.service;

import com.swapi.app.dto.SwapiFilmByIdResponseDto;
import com.swapi.app.dto.SwapiFilmResponseDto;

public interface FilmService {
    SwapiFilmResponseDto getFilmsData(int page, int limit, String title);
    SwapiFilmByIdResponseDto getFilmDataById(int id);
}
