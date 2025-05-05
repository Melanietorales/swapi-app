package com.swapi.app.dto;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

class PeopleListResponseDtoTest {

    @Test
    public void testPeopleListResponseDto() {
        PersonSummaryDto person = PersonSummaryDto.builder()
                .uid("1")
                .name("Luke Skywalker")
                .url("https://www.swapi.tech/api/people/1/")
                .gender("Male")
                .skinColor("Fair")
                .hairColor("Blond")
                .eyeColor("Blue")
                .height("172")
                .mass("80")
                .homeworld("https://www.swapi.tech/api/planets/1/")
                .created("2014-12-09T13:50:51.644000Z")
                .edited("2014-12-10T13:52:43.172000Z")
                .birthYear("19 BBY")
                .build();

        PeopleListResponseDto response = PeopleListResponseDto.builder()
                .totalRecords(82)
                .totalPages(9)
                .currentPage(1)
                .results(Collections.singletonList(person))
                .build();

        assertThat(response).isNotNull();
        assertThat(response.getTotalRecords()).isEqualTo(82);
        assertThat(response.getTotalPages()).isEqualTo(9);
        assertThat(response.getCurrentPage()).isEqualTo(1);
        assertThat(response.getResults()).hasSize(1);
        assertThat(response.getResults().get(0)).isEqualTo(person);

        assertThat(person).isNotNull();
        assertThat(person.getUid()).isEqualTo("1");
        assertThat(person.getName()).isEqualTo("Luke Skywalker");
        assertThat(person.getUrl()).isEqualTo("https://www.swapi.tech/api/people/1/");
        assertThat(person.getGender()).isEqualTo("Male");
        assertThat(person.getSkinColor()).isEqualTo("Fair");
        assertThat(person.getHairColor()).isEqualTo("Blond");
        assertThat(person.getEyeColor()).isEqualTo("Blue");
        assertThat(person.getHeight()).isEqualTo("172");
        assertThat(person.getMass()).isEqualTo("80");
        assertThat(person.getHomeworld()).isEqualTo("https://www.swapi.tech/api/planets/1/");
        assertThat(person.getCreated()).isEqualTo("2014-12-09T13:50:51.644000Z");
        assertThat(person.getEdited()).isEqualTo("2014-12-10T13:52:43.172000Z");
        assertThat(person.getBirthYear()).isEqualTo("19 BBY");
    }
}
