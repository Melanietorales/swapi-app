package com.swapi.app.dto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SwapiStarshipByIdResponseDtoTest {

    @Test
    public void testSwapiStarshipByIdResponseDto() {
        SwapiStarshipPropertiesDto starshipProperties = new SwapiStarshipPropertiesDto();
        starshipProperties.setUid("10");
        starshipProperties.setName("Death Star");

        StarshipSearchResultDto starshipSearchResult = new StarshipSearchResultDto(starshipProperties);

        SwapiStarshipByIdResponseDto response = SwapiStarshipByIdResponseDto.builder()
                .result(starshipSearchResult)
                .build();

        assertThat(response).isNotNull();
        assertThat(response.getResult()).isNotNull();
        assertThat(response.getResult().getProperties().getName()).isEqualTo("Death Star");
    }
}
