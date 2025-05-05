package com.swapi.app.service.impl;

import com.swapi.app.client.FilmClient;
import com.swapi.app.dto.SwapiFilmByIdResponseDto;
import com.swapi.app.dto.SwapiFilmResponseDto;
import com.swapi.app.mapper.SwapiFilmByIdResponseToDto;
import com.swapi.app.mapper.SwapiFilmListResponseToDto;
import com.swapi.app.model.SwapiFilmByIdResponse;
import com.swapi.app.model.SwapiFilmListResponse;
import com.swapi.app.service.FilmService;
import org.springframework.stereotype.Service;

@Service
public class FilmServiceImpl implements FilmService {
    private final FilmClient filmClient;

    public FilmServiceImpl(FilmClient filmClient) {
        this.filmClient = filmClient;
    }

    public SwapiFilmResponseDto getFilmsData(int page, int limit, String title) {
        SwapiFilmListResponse response = filmClient.getFilmsData(page, limit, title);
        return SwapiFilmListResponseToDto.toDto(response);
    }

    public SwapiFilmByIdResponseDto getFilmDataById(int id) {
        SwapiFilmByIdResponse response = filmClient.getFilmDataById(id);
        return SwapiFilmByIdResponseToDto.toDto(response);
    }
}
