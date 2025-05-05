package com.swapi.app.client;

import com.swapi.app.model.response.StarshipListResponse;
import com.swapi.app.model.response.StarshipByIdResponse;

public interface StarshipClient {
    StarshipListResponse getStarshipData(int page, int limit, String name, String model);
    StarshipByIdResponse getStarshipById(int id);

    }
