package com.swapi.app.client;

import com.swapi.app.model.response.FilmByIdResponse;
import com.swapi.app.model.response.FilmListResponse;

public interface FilmClient {
    FilmListResponse getFilmsData(int page, int limit, String title);
    FilmByIdResponse getFilmDataById(int id);
}
