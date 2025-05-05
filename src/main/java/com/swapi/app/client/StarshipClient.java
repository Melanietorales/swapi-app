package com.swapi.app.client;

import com.swapi.app.model.StarshipListResponse;

public interface StarshipClient {
    StarshipListResponse getStarshipData(int page, int limit, String name, String model);

    }
