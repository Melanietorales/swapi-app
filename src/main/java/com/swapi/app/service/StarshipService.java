package com.swapi.app.service;

import com.swapi.app.dto.StarshipListResponseDto;

public interface StarshipService {
    StarshipListResponseDto getStarshipData(int page, int limit, String name, String model);
}
