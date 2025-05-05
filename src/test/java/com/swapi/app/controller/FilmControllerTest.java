package com.swapi.app.controller;

import com.swapi.app.dto.FilmPropertiesDto;
import com.swapi.app.dto.SwapiFilmByIdResponseDto;
import com.swapi.app.dto.SwapiFilmListResultsDto;
import com.swapi.app.dto.SwapiFilmResponseDto;
import com.swapi.app.service.impl.FilmServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FilmControllerTest {

    @Test
    void testGetFilmDataById_OK() {
        FilmServiceImpl filmServiceImpl = mock(FilmServiceImpl.class);
        FilmPropertiesDto filmPropertiesDto = getFilmPropertiesDto();

        SwapiFilmListResultsDto swapiFilmListResultsDto = new SwapiFilmListResultsDto();
        swapiFilmListResultsDto.setProperties(filmPropertiesDto);
        SwapiFilmByIdResponseDto expectedResponse = new SwapiFilmByIdResponseDto();
        expectedResponse.setResult(swapiFilmListResultsDto);

        when(filmServiceImpl.getFilmDataById(1)).thenReturn(expectedResponse);

        FilmController controller = new FilmController(filmServiceImpl);
        ResponseEntity<SwapiFilmByIdResponseDto> result = controller.getFilmDataById(1);

        assertEquals(ResponseEntity.status(HttpStatus.OK).body(expectedResponse), result);
    }

    @Test
    void getFilmsData_OK() {
        FilmServiceImpl filmService = mock(FilmServiceImpl.class);
        SwapiFilmResponseDto expectedResponse = new SwapiFilmResponseDto();
        expectedResponse.setResult(Collections.singletonList(createFilmListResultsDto()));

        when(filmService.getFilmsData(1, 10, null)).thenReturn(expectedResponse);

        FilmController controller = new FilmController(filmService);

        ResponseEntity<SwapiFilmResponseDto> result = controller.getFilmsData(1, 10, null);

        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(expectedResponse, result.getBody());
    }

    private static FilmPropertiesDto getFilmPropertiesDto() {
        FilmPropertiesDto filmPropertiesDto = new FilmPropertiesDto();
        filmPropertiesDto.setCreated("createdTest");
        filmPropertiesDto.setEdited("editedTest");
        filmPropertiesDto.setStarships(Collections.singletonList("starships"));
        filmPropertiesDto.setVehicles(Collections.singletonList("vehicles"));
        filmPropertiesDto.setPlanets(Collections.singletonList("planets"));
        filmPropertiesDto.setProducer("producer");
        filmPropertiesDto.setTitle("title");
        filmPropertiesDto.setEpisodeId(1);
        filmPropertiesDto.setDirector("director");
        filmPropertiesDto.setReleaseDate(new Date());
        filmPropertiesDto.setOpeningCrawl("opnening");
        filmPropertiesDto.setCharacters(Collections.singletonList("characters"));
        filmPropertiesDto.setSpecies(Collections.singletonList("species"));
        filmPropertiesDto.setUrl("url");
        return filmPropertiesDto;
    }

    private static SwapiFilmListResultsDto createFilmListResultsDto() {
        SwapiFilmListResultsDto filmListResultsDto = new SwapiFilmListResultsDto();
        filmListResultsDto.setProperties(createFilmPropertiesDto());
        return filmListResultsDto;
    }

    private static FilmPropertiesDto createFilmPropertiesDto() {
        FilmPropertiesDto filmPropertiesDto = new FilmPropertiesDto();
        filmPropertiesDto.setCreated("2014-12-10T14:23:31.880000Z");
        filmPropertiesDto.setEdited("2014-12-12T11:26:08.000000Z");
        filmPropertiesDto.setStarships(Collections.singletonList("starshipUrl"));
        filmPropertiesDto.setVehicles(Collections.singletonList("vehicleUrl"));
        filmPropertiesDto.setPlanets(Collections.singletonList("planetUrl"));
        filmPropertiesDto.setProducer("Rick McCallum");
        filmPropertiesDto.setTitle("The Phantom Menace");
        filmPropertiesDto.setEpisodeId(1);
        filmPropertiesDto.setDirector("George Lucas");
        filmPropertiesDto.setReleaseDate(new Date());
        filmPropertiesDto.setOpeningCrawl("Turmoil has engulfed the Galactic Republic...");
        filmPropertiesDto.setCharacters(Collections.singletonList("characterUrl"));
        filmPropertiesDto.setSpecies(Collections.singletonList("speciesUrl"));
        filmPropertiesDto.setUrl("https://swapi.dev/api/films/1/");
        return filmPropertiesDto;
    }
}
