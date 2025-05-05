package com.swapi.app.controller;

import com.swapi.app.dto.StarshipListResponseDto;
import com.swapi.app.dto.StarshipSearchResultDto;
import com.swapi.app.dto.SwapiStarshipByIdResponseDto;
import com.swapi.app.dto.SwapiStarshipPropertiesDto;
import com.swapi.app.service.impl.StarshipServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class StarshipControllerTest {

    @Test
    void testGetAllStarships_OK() {
        StarshipServiceImpl starshipService = mock(StarshipServiceImpl.class);
        StarshipController controller = new StarshipController(starshipService);

        SwapiStarshipPropertiesDto starship = createStarshipDto();
        StarshipListResponseDto expectedResponse = StarshipListResponseDto.builder()
                .totalRecords(1)
                .totalPages(1)
                .previous("0")
                .next("2")
                .results(Collections.singletonList(starship))
                .build();

        when(starshipService.getStarshipData(1, 10, null, null)).thenReturn(expectedResponse);

        ResponseEntity<StarshipListResponseDto> response = controller.getStarshipData(1, 10, null, null);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedResponse, response.getBody());
    }

    @Test
    void testGetStarshipById_OK() {
        StarshipServiceImpl starshipService = mock(StarshipServiceImpl.class);
        StarshipController controller = new StarshipController(starshipService);

        SwapiStarshipPropertiesDto starship = createStarshipDto();
        SwapiStarshipByIdResponseDto expectedResponse = SwapiStarshipByIdResponseDto.builder()
                .result(new StarshipSearchResultDto(starship))
                .build();

        when(starshipService.getStarshipById(1)).thenReturn(expectedResponse);

        ResponseEntity<SwapiStarshipByIdResponseDto> response = controller.getStarshipById(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedResponse, response.getBody());
    }

    private SwapiStarshipPropertiesDto createStarshipDto() {
        return SwapiStarshipPropertiesDto.builder()
                .uid("1")
                .name("Millennium Falcon")
                .url("https://www.swapi.tech/api/starships/1/")
                .model("YT-1300 light freighter")
                .manufacturer("Corellian Engineering Corporation")
                .costInCredits("100000")
                .length("34.37")
                .maxAtmospheringSpeed("1050")
                .crew("4")
                .passengers("6")
                .cargoCapacity("100000")
                .consumables("2 months")
                .hyperdriveRating("0.5")
                .MGLT("75")
                .starshipClass("Light freighter")
                .created("2014-12-10T16:59:45.094000Z")
                .edited("2014-12-20T21:23:49.880000Z")
                .build();
    }
}
