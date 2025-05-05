package com.swapi.app.service.impl;

import com.swapi.app.client.StarshipClient;
import com.swapi.app.dto.StarshipListResponseDto;
import com.swapi.app.dto.SwapiStarshipByIdResponseDto;
import com.swapi.app.mapper.StarshipListResponseToDto;
import com.swapi.app.mapper.SwapiStarshipByIdResponseToDto;
import com.swapi.app.model.StarshipListResponse;
import com.swapi.app.model.SwapiStarshipByIdResponse;
import com.swapi.app.service.StarshipService;
import org.springframework.stereotype.Service;

@Service
public class StarshipServiceImpl implements StarshipService{

    private final StarshipClient starshipClient;

    public StarshipServiceImpl(StarshipClient starshipClient) {
        this.starshipClient = starshipClient;
    }

    @Override
    public StarshipListResponseDto getStarshipData(int page, int limit, String name, String model) {
        StarshipListResponse response = starshipClient.getStarshipData(page, limit, name, model);
        return StarshipListResponseToDto.toDto(response);
    }

    @Override
    public SwapiStarshipByIdResponseDto getStarshipById(int id) {
        SwapiStarshipByIdResponse response = starshipClient.getStarshipById(id);
        return SwapiStarshipByIdResponseToDto.toDto(response);
    }

}
