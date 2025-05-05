package com.swapi.app.mapper;

import com.swapi.app.dto.PeopleListResponseDto;
import com.swapi.app.model.PeopleListResponse;
import com.swapi.app.model.PersonSummary;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

class PeopleListResponseToDtoTest {

    @Test
    public void testToDto() {
        PersonSummary personSummary = new PersonSummary("1", "Luke Skywalker", "https://swapi.dev/api/people/1/", "male", "fair", "blond", "blue", "172", "77", "Tatooine", "2014-12-10T16:36:50.509000Z", "2014-12-20T21:23:49.867000Z", "19BBY");

        PeopleListResponse response = new PeopleListResponse(
                1, 1, 1, Collections.singletonList(personSummary)
        );

        PeopleListResponseDto dto = PeopleListResponseToDto.toDto(response);

        assertThat(dto).isNotNull();
        assertThat(dto.getTotalRecords()).isEqualTo(1);
        assertThat(dto.getTotalPages()).isEqualTo(1);
        assertThat(dto.getCurrentPage()).isEqualTo(1);
        assertThat(dto.getResults()).isNotEmpty();
        assertThat(dto.getResults().get(0).getName()).isEqualTo("Luke Skywalker");
        assertThat(dto.getResults().get(0).getGender()).isEqualTo("male");
    }
}
