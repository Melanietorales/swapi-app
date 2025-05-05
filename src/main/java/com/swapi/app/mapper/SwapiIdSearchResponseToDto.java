package com.swapi.app.mapper;

import com.swapi.app.dto.PersonSummaryDto;
import com.swapi.app.model.response.PersonSummary;
import com.swapi.app.model.response.PeopleIdSearchResponse;

public class SwapiIdSearchResponseToDto {

    public static PersonSummaryDto toDto(PeopleIdSearchResponse response) {
        PersonSummary person = response.getResult().getProperties();

        return PersonSummaryDto.builder()
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
    }
}
