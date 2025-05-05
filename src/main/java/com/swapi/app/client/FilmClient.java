package com.swapi.app.client;

import com.swapi.app.model.SwapiFilmByIdResponse;
import com.swapi.app.model.SwapiFilmListResponse;

public interface FilmClient {
    SwapiFilmListResponse getFilmsData(int page, int limit, String title);
    SwapiFilmByIdResponse getFilmDataById(int id);
}
