package com.swapi.app.mapper;

import com.swapi.app.model.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

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
                final List<PersonSummary> results = new ArrayList<>();

                if (isSearch) {
                    SwapiNameSearchResponse singleResponse = mapper.readValue(json, SwapiNameSearchResponse.class);

                    for (SwapiSearchResult person : singleResponse.getResult()) {
                        PersonSummary summary = getPersonSummary(person);
                        results.add(summary);
                    }

                    return new PeopleListResponse(results.size(), 1, page, results);

                } else {
                    SwapiPeopleResponse pagedResponse = mapper.readValue(json, SwapiPeopleResponse.class);

                    for (PersonSummary person : pagedResponse.getResults()) {
                        PersonSummary summary = PersonSummary.builder()
                                .uid(person.getUid())
                                .name(person.getName())
                                .url(person.getUrl())
                                .build();
                        results.add(summary);
                    }

                    return new PeopleListResponse(
                            pagedResponse.getTotalRecords(),
                            pagedResponse.getTotalPages(),
                            page,
                            results
                    );
                }

            } catch (Exception e) {
                throw new RuntimeException("Failed to map swapi response", e);
            }
        }

    private static PersonSummary getPersonSummary(SwapiSearchResult person) {
        PersonSummary props = person.getProperties();

        return PersonSummary.builder()
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
    }
}

