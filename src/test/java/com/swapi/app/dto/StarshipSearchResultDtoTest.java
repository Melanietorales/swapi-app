package com.swapi.app.dto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StarshipSearchResultDtoTest {

    @Test
    public void testStarshipSearchResultDto() {
        SwapiStarshipPropertiesDto starship = SwapiStarshipPropertiesDto.builder()
                .uid("1")
                .name("Starship")
                .url("https://example.com/starship/1")
                .build();

        StarshipSearchResultDto result = new StarshipSearchResultDto(starship);

        assertThat(result).isNotNull();
        assertThat(result.getProperties()).isEqualTo(starship);
    }
}
