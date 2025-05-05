package com.swapi.app.dto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

class FilmByIdResponseDtoTest {

    @Test
    public void testSwapiFilmByIdResponseDto() {
        FilmPropertiesDto filmProperties = new FilmPropertiesDto();
        filmProperties.setCreated("2014-12-10T14:23:31.880000Z");
        filmProperties.setEdited("2014-12-12T11:26:08.000000Z");
        filmProperties.setStarships(Arrays.asList("starship1", "starship2"));
        filmProperties.setVehicles(Collections.singletonList("vehicle1"));
        filmProperties.setPlanets(Arrays.asList("planet1", "planet2"));
        filmProperties.setProducer("Rick McCallum");
        filmProperties.setTitle("The Phantom Menace");
        filmProperties.setEpisodeId(1);
        filmProperties.setDirector("George Lucas");
        filmProperties.setReleaseDate(new Date());
        filmProperties.setOpeningCrawl("Turmoil has engulfed the Galactic Republic...");
        filmProperties.setCharacters(Collections.singletonList("character1"));
        filmProperties.setSpecies(Collections.singletonList("species1"));
        filmProperties.setUrl("https://swapi.dev/api/films/4/");

        SwapiFilmListResultsDto filmListResults = SwapiFilmListResultsDto.builder()
                .properties(filmProperties)
                .build();

        SwapiFilmByIdResponseDto response = SwapiFilmByIdResponseDto.builder()
                .result(filmListResults)
                .build();

        assertThat(response).isNotNull();
        assertThat(response.getResult()).isNotNull();
        assertThat(response.getResult().getProperties()).isEqualTo(filmProperties);
    }

}
