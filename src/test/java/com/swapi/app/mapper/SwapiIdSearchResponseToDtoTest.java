package com.swapi.app.mapper;

import com.swapi.app.dto.PersonSummaryDto;
import com.swapi.app.model.PersonSummary;
import com.swapi.app.model.SwapiIdSearchResponse;
import com.swapi.app.model.SwapiSearchResult;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SwapiIdSearchResponseToDtoTest {

    @Test
    public void testToDto() {

            PersonSummary personSummary = new PersonSummary(
                    "1", "Luke Skywalker", "http://swapi.dev/api/people/1/", "male",
                    "fair", "blond", "blue", "55", "77", "Tatooine",
                    "2014-12-0900Z", "2014-12-20T000Z", "19BBY");

            SwapiSearchResult searchResult = new SwapiSearchResult();
            searchResult.setProperties(personSummary);

            SwapiIdSearchResponse response = new SwapiIdSearchResponse();
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
