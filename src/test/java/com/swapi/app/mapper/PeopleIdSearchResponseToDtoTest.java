package com.swapi.app.mapper;

import com.swapi.app.dto.PersonSummaryDto;
import com.swapi.app.model.response.PersonSummary;
import com.swapi.app.model.response.PeopleIdSearchResponse;
import com.swapi.app.model.response.PeopleSearchResult;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PeopleIdSearchResponseToDtoTest {

    @Test
    public void testToDto() {

            PersonSummary personSummary = new PersonSummary(
                    "1", "Luke Skywalker", "http://swapi.dev/api/people/1/", "male",
                    "fair", "blond", "blue", "55", "77", "Tatooine",
                    "2014-12-0900Z", "2014-12-20T000Z", "19BBY");

            PeopleSearchResult searchResult = new PeopleSearchResult();
            searchResult.setProperties(personSummary);

            PeopleIdSearchResponse response = new PeopleIdSearchResponse();
            response.setResult(searchResult);

            PersonSummaryDto personSummaryDto = SwapiIdSearchResponseToDto.toDto(response);

            assertEquals(personSummary.getUid(), personSummaryDto.getUid());
            assertEquals(personSummary.getName(), personSummaryDto.getName());
            assertEquals(personSummary.getUrl(), personSummaryDto.getUrl());
            assertEquals(personSummary.getGender(), personSummaryDto.getGender());
            assertEquals(personSummary.getSkinColor(), personSummaryDto.getSkinColor());
            assertEquals(personSummary.getHairColor(), personSummaryDto.getHairColor());
            assertEquals(personSummary.getEyeColor(), personSummaryDto.getEyeColor());
            assertEquals(personSummary.getHeight(), personSummaryDto.getHeight());
            assertEquals(personSummary.getMass(), personSummaryDto.getMass());
            assertEquals(personSummary.getHomeworld(), personSummaryDto.getHomeworld());
            assertEquals(personSummary.getCreated(), personSummaryDto.getCreated());
            assertEquals(personSummary.getEdited(), personSummaryDto.getEdited());
            assertEquals(personSummary.getBirthYear(), personSummaryDto.getBirthYear());
        }
}
