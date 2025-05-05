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

    // Maps the raw response based on search or paged results.
    public PeopleListResponse mapPeopleResponse (String json, boolean isSearch, int page) {
        try {
            if (isSearch) {
                return mapPeopleSearchResponse(json, page);
            } else {
                return mapPeoplePagedResponse (json, page);
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to map swapi response", e);
        }
    }

    // Maps a search-based response for people data.
    private PeopleListResponse mapPeopleSearchResponse(String json, int page) throws IOException {
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

    // Maps a paginated response for people data.
    private PeopleListResponse mapPeoplePagedResponse (String json, int page) throws IOException {
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

    // Maps a raw Starship response based on search or paged results.
    public StarshipListResponse mapStarshipResponse(String json, boolean isSearch) {
        try {
            if (isSearch) {
                return mapStarshipSearchResponse(json);
            } else {
                return mapStarshipPagedResponse(json);
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to map Starship response from SWAPI", e);
        }
    }

    // Maps a search-based response for starships.
    private StarshipListResponse mapStarshipSearchResponse (String json) throws IOException {
            SwapiStarshipSearchResponse searchResponse = mapper.readValue(json, SwapiStarshipSearchResponse.class);
            List<SwapiStarshipProperties> results = new ArrayList<>();

            for (StarshipSearchResult result : searchResponse.getResult()) {
                SwapiStarshipProperties props = result.getProperties();

                SwapiStarshipProperties summary = SwapiStarshipProperties.builder()
                        .uid(props.getUid())
                        .name(props.getName())
                        .model(props.getModel())
                        .created(props.getCreated())
                        .edited(props.getEdited())
                        .consumables(props.getConsumables())
                        .cargoCapacity(props.getCargoCapacity())
                        .passengers(props.getPassengers())
                        .maxAtmospheringSpeed(props.getMaxAtmospheringSpeed())
                        .crew(props.getCrew())
                        .length(props.getLength())
                        .model(props.getModel())
                        .costInCredits(props.getCostInCredits())
                        .manufacturer(props.getManufacturer())
                        .pilots(props.getPilots())
                        .mglt(props.getMglt())
                        .starshipClass(props.getStarshipClass())
                        .hyperdriveRating(props.getHyperdriveRating())
                        .films(props.getFilms())
                        .url(props.getUrl())
                        .build();

                results.add(summary);
            }

            return new StarshipListResponse(null, null, null, null, results);
        }

    // Maps a paginated response for starships.
    private StarshipListResponse mapStarshipPagedResponse (String json) throws IOException {
            StarshipListResponse pagedResponse = mapper.readValue(json, StarshipListResponse.class);
            List<SwapiStarshipProperties> results = new ArrayList<>();

            for (SwapiStarshipProperties result : pagedResponse.getResults()) {
                results.add(SwapiStarshipProperties.builder()
                        .uid(result.getUid())
                        .name(result.getName())
                        .url(result.getUrl())
                        .build());
            }
            return new StarshipListResponse(
                    pagedResponse.getTotalRecords(),
                    pagedResponse.getTotalPages(),
                    pagedResponse.getPrevious(),
                    pagedResponse.getNext(),
                    results
            );
        }
}

