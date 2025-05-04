package com.example.demo.mapper;

import com.example.demo.DTO.PeopleListResponseDto;
import com.example.demo.DTO.PersonSummaryDto;
import com.example.demo.model.PeopleListResponse;
import com.example.demo.model.PersonSummary;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PeopleListResponseToDto {

    public static PeopleListResponseDto toDto(PeopleListResponse response) {
        List<PersonSummaryDto> dtoList = response.getResults().stream()
                .map(PeopleListResponseToDto::mapPersonSummaryToDto)
                .collect(Collectors.toList());

        return PeopleListResponseDto.builder()
                .totalRecords(response.getTotalRecords())
                .totalPages(response.getTotalPages())
                .currentPage(response.getCurrentPage())
                .results(dtoList)
                .build();
    }

    private static PersonSummaryDto mapPersonSummaryToDto(PersonSummary person) {
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


