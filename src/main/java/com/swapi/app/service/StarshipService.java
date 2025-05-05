package com.swapi.app.service;

import com.swapi.app.dto.StarshipListResponseDto;
import com.swapi.app.dto.SwapiStarshipByIdResponseDto;

public interface StarshipService {
    StarshipListResponseDto getStarshipData(int page, int limit, String name, String model);
    SwapiStarshipByIdResponseDto getStarshipById(int id);
}
