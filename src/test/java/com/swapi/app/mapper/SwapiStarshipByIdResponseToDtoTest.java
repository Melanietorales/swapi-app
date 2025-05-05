package com.swapi.app.mapper;

import com.swapi.app.dto.SwapiStarshipByIdResponseDto;
import com.swapi.app.dto.SwapiStarshipPropertiesDto;
import com.swapi.app.model.StarshipSearchResult;
import com.swapi.app.model.SwapiStarshipByIdResponse;
import com.swapi.app.model.SwapiStarshipProperties;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SwapiStarshipByIdResponseToDtoTest {

    @Test
    void testToDto() {
        SwapiStarshipProperties properties = getSwapiStarshipProperties();

        StarshipSearchResult  result = new StarshipSearchResult();
        result.setProperties(properties);

        SwapiStarshipByIdResponse response = new SwapiStarshipByIdResponse();
        response.setResult(result);

        SwapiStarshipByIdResponseDto dto = SwapiStarshipByIdResponseToDto.toDto(response);

        SwapiStarshipPropertiesDto dtoProps = dto.getResult().getProperties();
        assertEquals("10", dtoProps.getUid());
        assertEquals("Millennium Falcon", dtoProps.getName());
        assertEquals("https://swapi.dev/api/starships/10/", dtoProps.getUrl());
        assertEquals("2 months", dtoProps.getConsumables());
        assertEquals("75", dtoProps.getMGLT());
        assertEquals("Light freighter", dtoProps.getStarshipClass());
        assertEquals(Collections.singletonList("A New Hope"), dtoProps.getFilms());
    }

    private static SwapiStarshipProperties getSwapiStarshipProperties() {
        SwapiStarshipProperties properties = new SwapiStarshipProperties();
        properties.setUid("10");
        properties.setName("Millennium Falcon");
        properties.setUrl("https://swapi.dev/api/starships/10/");
        properties.setCreated("2024-01-01T00:00:00Z");
        properties.setEdited("2024-01-02T00:00:00Z");
        properties.setConsumables("2 months");
        properties.setCargoCapacity("100000");
        properties.setPassengers("6");
        properties.setMaxAtmospheringSpeed("1050");
        properties.setCrew("4");
        properties.setLength("34.37");
        properties.setModel("YT-1300 light freighter");
        properties.setCostInCredits("100000");
        properties.setManufacturer("Corellian Engineering Corporation");
        properties.setPilots(Collections.singletonList("Han Solo"));
        properties.setMglt("75");
        properties.setStarshipClass("Light freighter");
        properties.setHyperdriveRating("0.5");
        properties.setFilms(Collections.singletonList("A New Hope")); return properties;
    }
}