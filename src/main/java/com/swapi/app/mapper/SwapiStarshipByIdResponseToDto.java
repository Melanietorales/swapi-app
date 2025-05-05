package com.swapi.app.mapper;

import com.swapi.app.dto.StarshipSearchResultDto;
import com.swapi.app.dto.SwapiStarshipByIdResponseDto;
import com.swapi.app.dto.SwapiStarshipPropertiesDto;
import com.swapi.app.model.response.StarshipByIdResponse;
import com.swapi.app.model.response.StarshipProperties;

public class SwapiStarshipByIdResponseToDto {

    public static SwapiStarshipByIdResponseDto toDto(StarshipByIdResponse response) {
        StarshipProperties properties = response.getResult().getProperties();
        SwapiStarshipPropertiesDto propertiesDto = new SwapiStarshipPropertiesDto();
        propertiesDto.setUid(properties.getUid());
        propertiesDto.setName(properties.getName());
        propertiesDto.setUrl(properties.getUrl());
        propertiesDto.setCreated(properties.getCreated());
        propertiesDto.setEdited(properties.getEdited());
        propertiesDto.setConsumables(properties.getConsumables());
        propertiesDto.setCargoCapacity(properties.getCargoCapacity());
        propertiesDto.setPassengers(properties.getPassengers());
        propertiesDto.setMaxAtmospheringSpeed(properties.getMaxAtmospheringSpeed());
        propertiesDto.setCrew(properties.getCrew());
        propertiesDto.setLength(properties.getLength());
        propertiesDto.setModel(properties.getModel());
        propertiesDto.setCostInCredits(properties.getCostInCredits());
        propertiesDto.setManufacturer(properties.getManufacturer());
        propertiesDto.setPilots(properties.getPilots());
        propertiesDto.setMGLT(properties.getMglt());
        propertiesDto.setStarshipClass(properties.getStarshipClass());
        propertiesDto.setHyperdriveRating(properties.getHyperdriveRating());
        propertiesDto.setFilms(properties.getFilms());

        StarshipSearchResultDto starshipSearchResultDto = new StarshipSearchResultDto();
        starshipSearchResultDto.setProperties(propertiesDto);

        return SwapiStarshipByIdResponseDto.builder()
                .result(starshipSearchResultDto)
                .build();
    }
}
