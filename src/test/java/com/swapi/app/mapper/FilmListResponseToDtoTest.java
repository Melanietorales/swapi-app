package com.swapi.app.mapper;

import com.swapi.app.dto.SwapiFilmListResultsDto;
import com.swapi.app.dto.SwapiFilmResponseDto;
import com.swapi.app.model.response.FilmProperties;
import com.swapi.app.model.response.FilmListResponse;
import com.swapi.app.model.response.FilmListResults;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

class FilmListResponseToDtoTest {

    @Test
    public void testToDto() {
        FilmListResponse response = getSwapiFilmListResponse();

        SwapiFilmResponseDto dto = SwapiFilmListResponseToDto.toDto(response);

        assertThat(dto).isNotNull();
        assertThat(dto.getResult()).isNotNull();
        assertThat(dto.getResult()).hasSize(1);
        SwapiFilmListResultsDto resultDto = dto.getResult().get(0);
        assertThat(resultDto.getProperties()).isNotNull();
        assertThat(resultDto.getProperties().getTitle()).isEqualTo("Film Title");
        assertThat(resultDto.getProperties().getProducer()).isEqualTo("Producer A");
        assertThat(resultDto.getProperties().getEpisodeId()).isEqualTo(1);
        assertThat(resultDto.getProperties().getDirector()).isEqualTo("Director A");
        assertThat(resultDto.getProperties().getOpeningCrawl()).isEqualTo("Opening Crawl");
        assertThat(resultDto.getProperties().getStarships()).contains("starship1");
        assertThat(resultDto.getProperties().getVehicles()).contains("vehicle1");
        assertThat(resultDto.getProperties().getPlanets()).contains("planet1");
    }

    private static FilmListResponse getSwapiFilmListResponse() {
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

        FilmListResults result = new FilmListResults(properties);

        FilmListResponse response = new FilmListResponse();
        response.setResult(Collections.singletonList(result));
        return response;
    }
}
