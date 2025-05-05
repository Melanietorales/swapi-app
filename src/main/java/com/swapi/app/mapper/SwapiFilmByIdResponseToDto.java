package com.swapi.app.mapper;

import com.swapi.app.dto.FilmPropertiesDto;
import com.swapi.app.dto.SwapiFilmByIdResponseDto;
import com.swapi.app.dto.SwapiFilmListResultsDto;
import com.swapi.app.model.FilmProperties;
import com.swapi.app.model.SwapiFilmByIdResponse;

public class SwapiFilmByIdResponseToDto {

    public static SwapiFilmByIdResponseDto toDto(SwapiFilmByIdResponse response) {
        FilmProperties properties = response.getResult().getProperties();
        FilmPropertiesDto propertiesDto = new FilmPropertiesDto();
        propertiesDto.setCreated(properties.getCreated());
        propertiesDto.setEdited(properties.getEdited());
        propertiesDto.setStarships(properties.getStarships());
        propertiesDto.setVehicles(properties.getVehicles());
        propertiesDto.setPlanets(properties.getPlanets());
        propertiesDto.setProducer(properties.getProducer());
        propertiesDto.setTitle(properties.getTitle());
        propertiesDto.setEpisodeId(properties.getEpisodeId());
        propertiesDto.setDirector(properties.getDirector());
        propertiesDto.setReleaseDate(properties.getReleaseDate());
        propertiesDto.setOpeningCrawl(properties.getOpeningCrawl());
        propertiesDto.setCharacters(properties.getCharacters());
        propertiesDto.setSpecies(properties.getSpecies());
        propertiesDto.setUrl(properties.getUrl());

        SwapiFilmListResultsDto swapiFilmListResultsDto = new SwapiFilmListResultsDto();
        swapiFilmListResultsDto.setProperties(propertiesDto);

        return SwapiFilmByIdResponseDto.builder()
                .result(swapiFilmListResultsDto)
                .build();
    }
}
