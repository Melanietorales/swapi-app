package com.swapi.app.mapper;

import com.swapi.app.DTO.PersonSummaryDto;
import com.swapi.app.DTO.SwapiIdSearchResponseDto;
import com.swapi.app.DTO.SwapiSearchResultDto;
import com.swapi.app.model.PersonSummary;
import com.swapi.app.model.SwapiIdSearchResponse;
import com.swapi.app.model.SwapiSearchResult;
import org.springframework.stereotype.Component;

@Component
public class SwapiIdSearcheResponseToDto {

    public static SwapiIdSearchResponseDto toDto(SwapiIdSearchResponse response) {
        SwapiSearchResult result = response.getResult();
        PersonSummary person = result.getProperties();

        PersonSummaryDto personDto = PersonSummaryDto.builder()
                .uid(person.getUid())
                .name(person.getName())
                .url(person.getUrl())
                .gender(person.getGender())
                .skinColor(person.getSkinColor())
                .hairColor(person.getHairColor())
                .eyeColor(person.getEyeColor())
                .height(person.getHeight())
                .mass(person.getMass())
                .homeworld(person.getHomeworld())
                .created(person.getCreated())
                .edited(person.getEdited())
                .birthYear(person.getBirthYear())
                .build();

        SwapiSearchResultDto resultDto = new SwapiSearchResultDto();
        resultDto.setProperties(personDto);

        SwapiIdSearchResponseDto responseDto = new SwapiIdSearchResponseDto();
        responseDto.setResult(resultDto);

        return responseDto;
    }
}
