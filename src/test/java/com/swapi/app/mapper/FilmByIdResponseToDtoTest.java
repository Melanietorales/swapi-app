package com.swapi.app.mapper;

import com.swapi.app.dto.SwapiFilmByIdResponseDto;
import com.swapi.app.model.response.FilmProperties;
import com.swapi.app.model.response.FilmByIdResponse;
import com.swapi.app.model.response.FilmListResults;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

class FilmByIdResponseToDtoTest {

    @Test
    public void testToDto() {

        FilmByIdResponse response = getSwapiFilmByIdResponse();

        SwapiFilmByIdResponseDto dto = SwapiFilmByIdResponseToDto.toDto(response);

            assertThat(dto).isNotNull();
            assertThat(dto.getResult()).isNotNull();
            assertThat(dto.getResult().getProperties()).isNotNull();
            assertThat(dto.getResult().getProperties().getTitle()).isEqualTo("Film Title");
            assertThat(dto.getResult().getProperties().getProducer()).isEqualTo("Producer A");
            assertThat(dto.getResult().getProperties().getEpisodeId()).isEqualTo(1);
            assertThat(dto.getResult().getProperties().getDirector()).isEqualTo("Director A");
            assertThat(dto.getResult().getProperties().getOpeningCrawl()).isEqualTo("Opening Crawl");
            assertThat(dto.getResult().getProperties().getStarships()).contains("starship1");
            assertThat(dto.getResult().getProperties().getVehicles()).contains("vehicle1");
            assertThat(dto.getResult().getProperties().getPlanets()).contains("planet1");
        }

    private static FilmByIdResponse getSwapiFilmByIdResponse() {
        FilmProperties properties = new FilmProperties(
                "2022-01-01", "2022-01-01",
                Collections.singletonList("starship1"),
                Collections.singletonList("vehicle1"),
                Collections.singletonList("planet1"),
                "Producer A", "Film Title", 1,
                "Director A", new Date(), "Opening Crawl",
                Collections.singletonList("character1"),
                Collections.singletonList("species1"), "url"
        );

        FilmListResults filmListResults = new FilmListResults(properties);

        return new FilmByIdResponse(filmListResults);
    }
}
