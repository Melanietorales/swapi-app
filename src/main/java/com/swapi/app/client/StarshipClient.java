package com.swapi.app.client;

import com.swapi.app.model.StarshipListResponse;
import com.swapi.app.model.SwapiStarshipByIdResponse;

public interface StarshipClient {
    StarshipListResponse getStarshipData(int page, int limit, String name, String model);
    SwapiStarshipByIdResponse getStarshipById(int id);

    }
