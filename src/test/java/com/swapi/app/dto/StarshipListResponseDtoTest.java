package com.swapi.app.dto;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

class StarshipListResponseDtoTest {

    @Test
    public void testStarshipListResponseDto() {
        SwapiStarshipPropertiesDto starship = SwapiStarshipPropertiesDto.builder()
                .uid("1")
                .name("Starship")
                .url("https://example.com/starship/1")
                .created("2024-01-01T00:00:00Z")
                .edited("2024-01-01T01:00:00Z")
                .consumables("1 year")
                .cargoCapacity("50000")
                .passengers("10")
                .maxAtmospheringSpeed("500")
                .crew("5")
                .length("100")
                .model("Model X")
                .costInCredits("1000000")
                .manufacturer("Company")
                .pilots(Collections.singletonList("https://example.com/pilot/1"))
                .MGLT("10")
                .starshipClass("Battleship")
                .hyperdriveRating("5.0")
                .films(Collections.singletonList("https://example.com/film/1"))
                .build();

        StarshipListResponseDto response = StarshipListResponseDto.builder()
                .totalRecords(10)
                .totalPages(2)
                .previous("https://example.com/starships?page=1")
                .next("https://example.com/starships?page=2")
                .results(Collections.singletonList(starship))
                .build();

        assertThat(response).isNotNull();
        assertThat(response.getTotalRecords()).isEqualTo(10);
        assertThat(response.getTotalPages()).isEqualTo(2);
        assertThat(response.getPrevious()).isEqualTo("https://example.com/starships?page=1");
        assertThat(response.getNext()).isEqualTo("https://example.com/starships?page=2");
        assertThat(response.getResults()).hasSize(1);
        assertThat(response.getResults().get(0)).isEqualTo(starship);

        assertThat(starship).isNotNull();
        assertThat(starship.getUid()).isEqualTo("1");
        assertThat(starship.getName()).isEqualTo("Starship");
        assertThat(starship.getUrl()).isEqualTo("https://example.com/starship/1");
        assertThat(starship.getCreated()).isEqualTo("2024-01-01T00:00:00Z");
        assertThat(starship.getEdited()).isEqualTo("2024-01-01T01:00:00Z");
        assertThat(starship.getConsumables()).isEqualTo("1 year");
        assertThat(starship.getCargoCapacity()).isEqualTo("50000");
        assertThat(starship.getPassengers()).isEqualTo("10");
        assertThat(starship.getMaxAtmospheringSpeed()).isEqualTo("500");
        assertThat(starship.getCrew()).isEqualTo("5");
        assertThat(starship.getLength()).isEqualTo("100");
        assertThat(starship.getModel()).isEqualTo("Model X");
        assertThat(starship.getCostInCredits()).isEqualTo("1000000");
        assertThat(starship.getManufacturer()).isEqualTo("Company");
        assertThat(starship.getPilots()).contains("https://example.com/pilot/1");
        assertThat(starship.getMGLT()).isEqualTo("10");
        assertThat(starship.getStarshipClass()).isEqualTo("Battleship");
        assertThat(starship.getHyperdriveRating()).isEqualTo("5.0");
        assertThat(starship.getFilms()).contains("https://example.com/film/1");
    }
}
