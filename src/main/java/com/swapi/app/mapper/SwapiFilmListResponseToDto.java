package com.swapi.app.mapper;

import com.swapi.app.dto.FilmPropertiesDto;
import com.swapi.app.dto.SwapiFilmListResultsDto;
import com.swapi.app.dto.SwapiFilmResponseDto;
import com.swapi.app.model.response.FilmListResponse;

import java.util.List;
import java.util.stream.Collectors;

public class SwapiFilmListResponseToDto {

    public static SwapiFilmResponseDto toDto(FilmListResponse response) {
        List<SwapiFilmListResultsDto> resultDtos = response.getResult().stream()
                .map(result -> {
                    FilmPropertiesDto properties = new FilmPropertiesDto();
                    properties.setCreated(result.getProperties().getCreated());
                    properties.setEdited(result.getProperties().getEdited());
                    properties.setStarships(result.getProperties().getStarships());
                    properties.setVehicles(result.getProperties().getVehicles());
                    properties.setPlanets(result.getProperties().getPlanets());
                    properties.setProducer(result.getProperties().getProducer());
                    properties.setTitle(result.getProperties().getTitle());
                    properties.setEpisodeId(result.getProperties().getEpisodeId());
                    properties.setDirector(result.getProperties().getDirector());
                    properties.setReleaseDate(result.getProperties().getReleaseDate());
                    properties.setOpeningCrawl(result.getProperties().getOpeningCrawl());
                    properties.setCharacters(result.getProperties().getCharacters());
                    properties.setSpecies(result.getProperties().getSpecies());
                    properties.setUrl(result.getProperties().getUrl());

                    SwapiFilmListResultsDto dto = new SwapiFilmListResultsDto();
                    dto.setProperties(properties);
                    return dto;
                })
                .collect(Collectors.toList());

        return SwapiFilmResponseDto.builder()
                .result(resultDtos)
                .build();
    }

}

