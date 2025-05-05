package com.swapi.app.mapper;

import com.swapi.app.model.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class SwapiMapper {

    private final ObjectMapper mapper;

    public SwapiMapper(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public PeopleListResponse mapResponse(String json, boolean isSearch, int page) {
        try {
            if (isSearch) {
                return mapSearchResponse(json, page);
            } else {
                return mapPagedResponse(json, page);
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to map swapi response", e);
        }
    }

    private PeopleListResponse mapSearchResponse(String json, int page) throws IOException {
        SwapiNameSearchResponse singleResponse = mapper.readValue(json, SwapiNameSearchResponse.class);
        List<PersonSummary> results = new ArrayList<>();

        for (SwapiSearchResult person : singleResponse.getResult()) {
            PersonSummary props = person.getProperties();

            PersonSummary summary = PersonSummary.builder()
                    .uid(props.getUid())
                    .name(props.getName())
                    .gender(props.getGender())
                    .skinColor(props.getSkinColor())
                    .hairColor(props.getHairColor())
                    .eyeColor(props.getEyeColor())
                    .height(props.getHeight())
                    .mass(props.getMass())
                    .homeworld(props.getHomeworld())
                    .url(props.getUrl())
                    .birthYear(props.getBirthYear())
                    .created(props.getCreated())
                    .edited(props.getEdited())
                    .build();
            results.add(summary);
        }

        return new PeopleListResponse(results.size(), 1, page, results);
    }

    private PeopleListResponse mapPagedResponse(String json, int page) throws IOException {
        SwapiPeopleResponse pagedResponse = mapper.readValue(json, SwapiPeopleResponse.class);
        List<PersonSummary> results = new ArrayList<>();

        for (PersonSummary person : pagedResponse.getResults()) {
            results.add(PersonSummary.builder()
                    .uid(person.getUid())
                    .name(person.getName())
                    .url(person.getUrl())
                    .build());
        }

        return new PeopleListResponse(
                pagedResponse.getTotalRecords(),
                pagedResponse.getTotalPages(),
                page,
                results
        );
    }

}

