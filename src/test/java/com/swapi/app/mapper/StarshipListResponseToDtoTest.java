package com.swapi.app.mapper;

import com.swapi.app.dto.StarshipListResponseDto;
import com.swapi.app.model.StarshipListResponse;
import com.swapi.app.model.SwapiStarshipProperties;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class StarshipListResponseToDtoTest {


    @Test
    public void testToDto() {
        StarshipListResponse response = getStarshipListResponse();

        StarshipListResponseDto dto = StarshipListResponseToDto.toDto(response);

        assertThat(dto).isNotNull();
        assertThat(dto.getTotalRecords()).isEqualTo(1);
        assertThat(dto.getTotalPages()).isEqualTo(1);
        assertThat(dto.getPrevious()).isEqualTo("url");
        assertThat(dto.getNext()).isNull();
        assertThat(dto.getResults()).isNotEmpty();
        assertThat(dto.getResults().get(0).getName()).isEqualTo("Falcon");
        assertThat(dto.getResults().get(0).getModel()).isEqualTo("Model A");
    }

    private static StarshipListResponse getStarshipListResponse() {
        SwapiStarshipProperties starshipProperties = new SwapiStarshipProperties(
                "1", "Falcon", "url", "2022-01-01", "2022-01-01", "1 year",
                "100", "3", "500", "2", "20", "Model A", "10000",
                "Manufacturer A", Collections.singletonList("pilot1"), "100", "Class A", "1.0", Collections.singletonList("film1")
        );

        return new StarshipListResponse(
                1, 1, "url", null, Collections.singletonList(starshipProperties)
        );
    }
}

